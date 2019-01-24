package Vista;

import Modelo.Histogram;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.ChartPanel;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class HistogramDisplay extends ApplicationFrame{

    private final Histogram<String> histogram;

    private DefaultCategoryDataset dataSet;

    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }

    public void execute(){
        setVisible(true);
    }

    private ChartPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = 
                ChartFactory.createBarChart("Histograma JFreeChart", 
                        "Dominios email", "Nยบ de emails", dataSet, 
                        PlotOrientation.VERTICAL, false, false, 
                        rootPaneCheckingEnabled);
        return chart;
    }

    private DefaultCategoryDataset createDataset(){
        dataSet = new DefaultCategoryDataset();
        for (String key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", key);
        }
        return dataSet;
    }
}
