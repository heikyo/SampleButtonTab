package com.sample.buttontab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SampleButtonTabActivity extends Activity implements OnClickListener {
	
	private static final int MODE_A = 1;
	private static final int MODE_B = 2;
	
	private Button aButton;
	private Button bButton;
	private Button changeButton;
	private Button countButton;
	private TextView countText;
	private int aCount = 0;
	private int bCount = 0;
	
	private int mode;
	
	public SampleButtonTabActivity () {
		mode = MODE_A;
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        
		aButton = (Button)findViewById(R.id.modeAbutton);
		aButton.setBackgroundResource(R.drawable.focus_button);
		bButton = (Button)findViewById(R.id.modeBbutton);
		bButton.setBackgroundResource(R.drawable.notfocus_button);
		changeButton = (Button)findViewById(R.id.changebutton);
		changeButton.setOnClickListener(this);
		countButton = (Button)findViewById(R.id.countbutton);
		countButton.setOnClickListener(this);
		countText = (TextView)findViewById(R.id.counttext);
	}
    
	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.changebutton:
			modeChange();
			break;
		case R.id.countbutton:
			count();
			break;
		}
	}
    
	private void modeChange() {
		switch(mode) {
		case MODE_A:
			mode = MODE_B;
			aButton.setBackgroundResource(R.drawable.notfocus_button);
			bButton.setBackgroundResource(R.drawable.focus_button);
			countText.setText("MODE_B: " + String.valueOf(bCount));
			break;
		case MODE_B:
			mode = MODE_A;
			aButton.setBackgroundResource(R.drawable.focus_button);
			bButton.setBackgroundResource(R.drawable.notfocus_button);
			countText.setText("MODE_A: " + String.valueOf(aCount));
			break;
		}
	}
	
	private void count() {
		switch(mode) {
		case MODE_A:
			aCount++;
			countText.setText("MODE_A: " + String.valueOf(aCount));
			break;
		case MODE_B:
			bCount++;
			countText.setText("MODE_B: " + String.valueOf(bCount));
			break;
		}
		
	}
}