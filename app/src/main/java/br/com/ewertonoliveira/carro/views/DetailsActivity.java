package br.com.ewertonoliveira.carro.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.ewertonoliveira.carro.R;
import br.com.ewertonoliveira.carro.constants.CarsConstants;
import br.com.ewertonoliveira.carro.data.CarMock;
import br.com.ewertonoliveira.carro.entities.Car;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private CarMock mCarMock;
    private Car mCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.mCarMock = new CarMock(this);

        this.mViewHolder.imgCarPicture = (ImageView) findViewById(R.id.img_car_pic);
        this.mViewHolder.textModel = (TextView) findViewById(R.id.text_car_model);
        this.mViewHolder.textManufacturer = (TextView) findViewById(R.id.text_manufacturer);
        this.mViewHolder.textHorsePower = (TextView) findViewById(R.id.text_horse_power);
        this.mViewHolder.textPrice = (TextView) findViewById(R.id.text_price);

        this.getDataFromActivity();

        this.setData();
    }

    private void setData() {
        this.mViewHolder.textModel.setText(this.mCar.model);
        this.mViewHolder.textHorsePower.setText(String.valueOf(this.mCar.horsePower));
        this.mViewHolder.textPrice.setText("R$ "+String.valueOf(this.mCar.price));
        this.mViewHolder.imgCarPicture.setImageDrawable(this.mCar.picture);
    }

    private void getDataFromActivity() {
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            this.mCar = this.mCarMock.get(extras.getInt(CarsConstants.CARRO_ID));
        }
    }

    private static class ViewHolder {
        ImageView imgCarPicture;
        TextView textModel;
        TextView textManufacturer;
        TextView textHorsePower;
        TextView textPrice;
    }
}
