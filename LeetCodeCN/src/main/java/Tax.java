import org.junit.Test;
import java.util.LinkedList;
import java.util.List;

public class Tax {

    // 税率实体类
    class TaxSection {
        double start;  // 如果要考虑精度丢失问题，应该使用BigDecimal 或者根据业务需要定义金额类。
        double end;
        double taxRate;

        public TaxSection(double start, double end, double taxRate) {
            this.start = start;
            this.end = end;
            this.taxRate = taxRate;
        }
    }

    // 计算示例
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

        double tax = taxHandlerChain.calculateTax(amount);
        return (int) tax;
    }

    // 税率计算基类 Node
    abstract class AbstractTaxHandler {

        // protected AbstractTaxHandler curHandler;
        protected AbstractTaxHandler nextHandler;

        public AbstractTaxHandler getNextHandler() {
            return nextHandler;
        }

        public void setNextHandler(AbstractTaxHandler handler) {
            this.nextHandler = handler;
        }

        protected abstract double calculateCurrentSection(double amount);

        protected double calculateNextSection(double amount) {
            if (nextHandler != null) {
                return nextHandler.calculateCurrentSection(amount);
            } else {
                return 0.0;
            }
        }
    }

    // 子类
    class TaxSectionHandler extends AbstractTaxHandler {
        TaxSection taxSection;

        public TaxSectionHandler(TaxSection taxSection) {
            this.taxSection = taxSection;
        }

        public double calculateCurrentSection(double amount) {
            if (amount > taxSection.start) {
                double totalTax = Math.min((amount - taxSection.start), taxSection.end - taxSection.start) * taxSection.taxRate;
                return totalTax + calculateNextSection(amount);
            }
            return 0.0;
        }

        protected double calculateNextSection(double amount) {
            if (nextHandler != null) {
                return nextHandler.calculateCurrentSection(amount);
            } else {
                return 0.0;
            }
        }
    }

    // 责任链模式 装载TaxSectionHandler
    class TaxHandlerChain {
        // NodeList head
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

        public double calculateTax(int amount) {
            if (headHandler != null) {
                return headHandler.calculateCurrentSection(amount);
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