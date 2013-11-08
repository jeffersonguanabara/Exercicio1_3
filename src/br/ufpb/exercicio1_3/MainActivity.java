package br.ufpb.exercicio1_3;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private View mColorRegionButton1;
	private View mColorRegionButton2;
	private int[] mColorChoices = { Color.BLACK, Color.BLUE, Color.CYAN,
			Color.GREEN, Color.RED, Color.YELLOW };
	private View contText;
	int cont = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mColorRegionButton1 = (Button)findViewById(R.id.button1);
		mColorRegionButton2 = (Button)findViewById(R.id.button2);
		mColorRegionButton1.setOnClickListener(new ColorRandomizer());
		mColorRegionButton2.setOnClickListener(new ColorRandomizer());
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void setRegionColorButton(int color) {
		if(mColorRegionButton1.isPressed()){
			((Button) mColorRegionButton1).setTextColor(color);
			cont++;
		}else if(mColorRegionButton2.isPressed()){
			((Button) mColorRegionButton2).setTextColor(color);
			cont++;
		}
	}
	
	private class ColorRandomizer implements OnClickListener {

		@Override
		public void onClick(View v) {
			Random generator = new Random();
			int index = generator.nextInt(mColorChoices.length);
			setRegionColorButton(mColorChoices[index]);
			
			Integer.toString(cont);
    		Toast tempMessage = Toast.makeText(MainActivity.this, Integer.toString(cont), Toast.LENGTH_SHORT);
    		
    		tempMessage.show();
		}
		
	}
	

}
