package com.kevintyang.codeclicker.codeclicker;

        import android.app.Activity;
        import android.os.Bundle;
        import android.os.Handler;
        import android.widget.TextView;

public class TextViewUpdater extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_code);

        updateTextView();

        handler.removeCallbacks(updateTextViewTask);
        handler.postDelayed(updateTextViewTask, 1000);
    }

    private Runnable updateTextViewTask = new Runnable() {
        public void run() {
            updateTextView();
            handler.postDelayed(this, 100);
        }
    };

    private void updateTextView() {
        final TextView code = (TextView) findViewById(R.id.codeTextView);
        code.setText( CodeCounters.getCurrentStr() );
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(updateTextViewTask);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.removeCallbacks(updateTextViewTask);
        handler.postDelayed(updateTextViewTask, 200);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if ( handler != null )
            handler.removeCallbacks(updateTextViewTask);
        handler = null;
    }

    private Handler handler = new Handler();
}