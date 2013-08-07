package edu.mexanjuadha.dynamicbarchart;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	GraphicalView view;

	List<CategorySeries> series = new ArrayList<CategorySeries>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		int[] y = { 100, 200, 300};
		String[] label = {"Ya","Tidak","Belum"};
	
		for (int x = 0; x < label.length; x++) {
			CategorySeries seri = new CategorySeries(label[x]);
		    series.add(seri);
		 
		}
	
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
	
				series.get(0).add("Bar " + (1 + 1), 100);
				series.get(1).add("Bar " + (2 + 2), 200);
				series.get(2).add("Bar " + (3 + 3), 300);
				
				series.get(0).add("Bar " + (1 + 1), 400);
				series.get(1).add("Bar " + (2 + 2), 500);
				series.get(2).add("Bar " + (3 + 3), 600);
				
				series.get(0).add("Bar " + (1 + 1), 700);
				series.get(1).add("Bar " + (2 + 2), 800);
				series.get(2).add("Bar " + (3 + 3), 900);
				dataset.addSeries(series.get(0).toXYSeries());
				dataset.addSeries(series.get(1).toXYSeries());
				dataset.addSeries(series.get(2).toXYSeries());
		

	
		LinearLayout ln = (LinearLayout) findViewById(R.id.chart);

		
		

		XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
		mRenderer.setChartTitle("Contoh Graph");
		mRenderer.setXTitle("X VALUES");
		mRenderer.setYTitle("Y VALUES");
		mRenderer.setAxesColor(Color.parseColor("#D7372F"));
		mRenderer.setLabelsColor(Color.parseColor("#000000"));
		
		mRenderer.setBackgroundColor(Color.parseColor("#FFFFFF"));
	
		mRenderer.setBarSpacing(1);
	
		mRenderer.setApplyBackgroundColor(true);
		mRenderer.setBackgroundColor(Color.WHITE);
		mRenderer.setMarginsColor(Color.WHITE);
	
		XYSeriesRenderer renderer = new XYSeriesRenderer();
		renderer.setColor(Color.parseColor("#D7372F"));
		renderer.setDisplayChartValues(true);
		renderer.setChartValuesSpacing(200);
		mRenderer.addSeriesRenderer(renderer);
		
		XYSeriesRenderer renderer2 = new XYSeriesRenderer();
		renderer2.setColor(Color.parseColor("#000675"));
		renderer2.setDisplayChartValues(true);

		mRenderer.addSeriesRenderer(renderer2);
		
		XYSeriesRenderer renderer3 = new XYSeriesRenderer();
		renderer3.setColor(Color.parseColor("#000000"));
		renderer3.setDisplayChartValues(true);
		
		mRenderer.addSeriesRenderer(renderer3);

		view = ChartFactory.getBarChartView(this, dataset, mRenderer,
				Type.DEFAULT);
		view.setBackgroundColor(Color.parseColor("#FFFFFF"));
		
		ln.addView(view);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
