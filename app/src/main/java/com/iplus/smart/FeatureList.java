
package com.iplus.smart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FeatureList extends Activity {

    private static String TAG = "FeatureListActivity";
    private ListView featureListView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feature_list);

        this.featureListView = (ListView) findViewById(R.id.FeatureListView);

        // Create an ArrayAdapter that will contain all list items
        String[] featuresArray = getResources().getStringArray(R.array.featureList);

        /*
         * Assign the name array to that adapter and also choose a simple layout
         * for the list items
         */
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, featuresArray);

        // Assign the adapter to featureListView
        this.featureListView.setAdapter(arrayAdapter);
        this.featureListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        this.featureListView.setScrollingCacheEnabled(false);

        // handle the item click event int featureListView
        this.featureListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                Log.v(TAG, "position:" + String.valueOf(position) + "  "
                        + "id:" + String.valueOf(id));
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(FeatureList.this, DeviceInfo.class);
                        break;
                    case 1:
                        intent = new Intent(FeatureList.this, ApplicationList.class);
                        break;
                    case 2:
                        intent = new Intent(FeatureList.this, BatteryInfo.class);
                        break;
                    case 3:
                        intent = new Intent(FeatureList.this, SensorsInfo.class);
                        break;
                    case 4:
                        intent = new Intent(FeatureList.this, VibratorActivity.class);
                        break;
                    case 5:
                        intent = new Intent(FeatureList.this, AudioTone.class);
                        break;
                    case 6:
                        intent = new Intent(FeatureList.this, HttpClient.class);
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
