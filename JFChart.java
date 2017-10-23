import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.DynamicTimeSeriesCollection;
import org.jfree.data.time.Second;
import java.util.Date;
import javax.swing.*;
import java.text.SimpleDateFormat;

public class JFChart extends JPanel{

    private final DynamicTimeSeriesCollection dataset;
    private final JFreeChart chart;



    public JFChart(final String title) {
        dataset = new DynamicTimeSeriesCollection(1, 2000, new Second());
        Date date = new Date();
        dataset.setTimeBase(new Second(date));
        dataset.addSeries(new float[1], 0, title);
        chart = ChartFactory.createTimeSeriesChart(title, "Temps", title, dataset, true, true, false);
        final XYPlot plot = chart.getXYPlot();
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setFixedAutoRange(10000);
        axis.setDateFormatOverride(new SimpleDateFormat("ss.SS"));
        final ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel);
    }

    public void update(double value) {
        float[] newData = new float[1];
        newData[0] = (float) value;
        dataset.advanceTime();
        dataset.appendData(newData);
    }
}
