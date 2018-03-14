package maven;
import java.awt.Color;
import java.io.*;
import java.util.*;
import org.jfree.chart.*;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JFrame;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.chart.ChartUtilities;




public class HistogramGenerator {

	public static void main(String[] args) {

		try {
            System.out.print("Enter the file name with extension : ");

            Scanner input = new Scanner(System.in);

            File file = new File(input.nextLine());

            input = new Scanner(file);
        
            int[] frequency = new int[11];
            
                frequency[0]=0;
                frequency[1]=0;
                frequency[2]=0;
                frequency[3]=0;
                frequency[4]=0;
                frequency[5]=0;
                frequency[6]=0;
                frequency[7]=0;
                frequency[8]=0;
                frequency[9]=0;
                frequency[10]=0;
             while(input.hasNext()) {
                int a=input.nextInt();
                if (a==0){
                    ++frequency[0];
                }else if(a==1){
                    ++frequency[1];
                }else if(a==2){
                    ++frequency[2];
                }else if(a==3){
                    ++frequency[3];
                }else if(a==4){
                    ++frequency[4];
                }else if(a==5){
                    ++frequency[5];
                }else if(a==6){
                    ++frequency[6];
                }else if(a==7){
                    ++frequency[7];
                }else if(a==8){
                    ++frequency[8];
                }else if(a==9){
                    ++frequency[9];
                }else if(a==10){
                    ++frequency[10];
                }
            }

            for (int i=0; i<11; i++){
                     System.out.printf("%4d%10d\n",i, frequency[i]);
            	}
            input.close();
        HistogramGenerator hg = new HistogramGenerator();
    		hg.myChart(frequency);
    		hg.myBar(frequency);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	
	
	public int getFreq(int[] frequency) {
		return frequency[11];
	}
	
	
	 
	 public void myChart(int[] frequency) {
		
		
        XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries grades = new XYSeries("grades");
		
		
		
		for (int i = 0; i < 11; i++) {
			grades.add(i, frequency[i]);
		}
		
		boolean legend = false; 
		boolean tooltips = false; 
		boolean urls = false;
		
		dataset.addSeries(grades);
		JFreeChart chart = ChartFactory.createXYLineChart("Grade Frequency", "Grade", "Frequency", dataset, PlotOrientation.VERTICAL, legend, tooltips, urls);
		JFrame frame = new JFrame("Grade Frequency Chart");
	    frame.setContentPane(new ChartPanel(chart));
		frame.pack();
		frame.setVisible(true);
		
	}
	
	 
	//i tried to create a bar chart but for parameter i should use (java.awt.event.ActionEvent evt)
	//however couldn't find a way to also use the frequency array.
	public void myBar(int[] frequency){
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    
	    
	    for(int i=0; i<frequency.length;i++) {
	    	   dataset.setValue(frequency[i], "grades", "frequency");
	    }
	    
	    JFreeChart chart =ChartFactory.createBarChart("Grades","GradeFreq","",dataset,PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Grade Frequency", chart);
        frame.setVisible(true);
        frame.setSize(450,350);
	       
	}
}
