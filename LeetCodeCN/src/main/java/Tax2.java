// 1.请使用Java语言实现如下税率计算：
//区间(section)   税率(tax rate)
//1~5000          0%
//5001~8000       3%
//8001~17000      10%
//60001~85000     35%
//30001~40000     25%
//40001~60000     30%
//17001~30000     20%
//85001~          45%
//
//e.g.
//税前 10000 元
//收税金额 = 5000 * 0.0 + 3000 * 0.03 + 2000 * 0.1
//
//分析: 找到当前金额的税率范围，找到下一个税率的金额范围，其差值即为当前区段所缴税率的基本值，然后乘以当前区间的税率即可
//
//
//
//要求
//1. 使用面向对象设计；
//2. 代码规范，变量命名等；
//3. 具备可扩展性，当税率配置的区间、税率发生变化时（如通过配置文件或数据库变更），以下实现必需能够兼容；
//4. 笔试时间30分钟；
//5. 可以在本地IDE中实现；
//6. 在笔记时间结束前，不管是否完成，都将代码贴贴至笔试页面上，若未贴代码视作弃权处理。
//7. 代码结构优雅
//
//
//// 不需要考虑计算精度问题，税率区间的边界值为整型
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

public class Tax2 {

    // 税率实体类
    class TaxSection {
        double start;  // 如果考虑精度丢失问题，可以试用BigDecimal，或者根据业务自定义金额类
        double end;
        double taxRate;

        public TaxSection(double start, double end, double taxRate) {
            this.start = start;
            this.end = end;
            this.taxRate = taxRate;
        }
    }

    // 计算方法
    public int calculate(int amount) {
        TaxHandlerChain taxHandlerChain = new TaxHandlerChain();
        List<TaxSection> taxSections = new LinkedList<>();
        // 模拟加载 get taxSections from configuration or DB source.
        taxSections.add(new TaxSection(0, 5000, 0));
        taxSections.add(new TaxSection(5000, 8000, 0.03));
        taxSections.add(new TaxSection(8000, 17000, 0.10));
        taxSections.add(new TaxSection(17000, 30000, 0.20));
        taxSections.add(new TaxSection(30000, 40000, 0.25));
        taxSections.add(new TaxSection(40000, 60000, 0.30));
        taxSections.add(new TaxSection(60000, 85000, 0.35));
        taxSections.add(new TaxSection(85000, Integer.MAX_VALUE, 0.45));

        for (TaxSection taxSection: taxSections) {
            taxHandlerChain.addHandler(new TaxSectionHandler(taxSection));
        }

        // 计算策略
        Function<TaxSection, Double> function = taxSection -> Math.min((amount - taxSection.start), taxSection.end - taxSection.start) * taxSection.taxRate;
        double tax = taxHandlerChain.calculateTax(amount, function);
        return (int) tax;
    }

    // 税率计算基类
    abstract class AbstractTaxHandler {

//        protected AbstractTaxHandler curHandler;
        protected AbstractTaxHandler nextHandler;

        public AbstractTaxHandler getNextHandler() {
            return nextHandler;
        }

        public void setNextHandler(AbstractTaxHandler handler) {
            this.nextHandler = handler;
        }

        protected abstract double calculateCurrentSection(double amount, Function<TaxSection, Double> function);

        protected abstract  double calculateNextSection(double amount, Function<TaxSection, Double> function);
    }

    // 子类
    class TaxSectionHandler extends AbstractTaxHandler {
        TaxSection taxSection;

        public TaxSectionHandler(TaxSection taxSection) {
            this.taxSection = taxSection;
        }

        public double calculateCurrentSection(double amount, Function<TaxSection, Double> function) {
            if (amount > taxSection.start) {
                double totalTax = function.apply(taxSection);
                return totalTax + calculateNextSection(amount, function);
            }
            return 0.0;
        }

        protected double calculateNextSection(double amount, Function<TaxSection, Double> function) {
            if (nextHandler != null) {
                return nextHandler.calculateCurrentSection(amount, function);
            } else {
                return 0.0;
            }
        }
    }

    // 责任链模式 装载TaxSectionHandler
    class TaxHandlerChain {
        private AbstractTaxHandler headHandler;

        public void addHandler(AbstractTaxHandler handler) {
            if (headHandler == null) {
                headHandler = handler;
            } else {
                AbstractTaxHandler currentHandler = headHandler;
                while (currentHandler.getNextHandler() != null) {
                    currentHandler = currentHandler.getNextHandler();
                }
                currentHandler.setNextHandler(handler);
            }
        }

        public double calculateTax(int amount, Function<TaxSection, Double> function) {
            if (headHandler != null) {
                return headHandler.calculateCurrentSection(amount, function);
            } else {
                return 0.0;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(calculate(10000));
    }
}