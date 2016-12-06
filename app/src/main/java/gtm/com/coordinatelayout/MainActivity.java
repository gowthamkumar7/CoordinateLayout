package gtm.com.coordinatelayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author Gowtham kumar paidimuddhala
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String x[] = {"Nougat", "Marshmallow", "Lollipop", "KitKat", "Jelly Bean", "Ice Cream Sandwich", "Honeycomb", "Gingerbread", "Froyo", "Eclair", "Donut", "Cupcake", "Beta", "Alpha", "India", "Hyderabad", "United States", "Sanjose", "United Kingdom", "Manchesters"}; //Dummy List
        ListView lv = (ListView) findViewById(R.id.lv);
        ArrayAdapter mAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, x);
        lv.setAdapter(mAdapter);
        final FloatingActionButton mFAB = (FloatingActionButton) findViewById(R.id.floatingActionButton); //Bindig of FAB
        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Passing Root view for the Snackbar
                Snackbar.make(findViewById(R.id.cor), "Sample Snack bar", Snackbar.LENGTH_LONG).setAction("CLICK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();
            }
        });


        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            int mLastFirstVisibleItem;

            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int i1, int i2) {
                if (mLastFirstVisibleItem < firstVisibleItem) {
                    mFAB.hide();
                }
                if (mLastFirstVisibleItem > firstVisibleItem) {
                    mFAB.show();

                }
                mLastFirstVisibleItem = firstVisibleItem;

            }
        });
    }
}
