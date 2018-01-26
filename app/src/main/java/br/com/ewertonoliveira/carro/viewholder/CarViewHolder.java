package br.com.ewertonoliveira.carro.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.ewertonoliveira.carro.R;
import br.com.ewertonoliveira.carro.entities.Car;
import br.com.ewertonoliveira.carro.listener.OnListClickInterationListener;

public class CarViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImgCarPicture;
    private TextView mTextCarModel;
    private TextView mTextViewDetails;

    public CarViewHolder(View itemView) {
        super(itemView);
        this.mImgCarPicture = (ImageView) itemView.findViewById(R.id.img_car_pic);
        this.mTextCarModel = (TextView) itemView.findViewById(R.id.text_car_model);
        this.mTextViewDetails = (TextView) itemView.findViewById(R.id.text_view_details);
    }

    public void bindData(final Car car, final OnListClickInterationListener listener) {
        this.mImgCarPicture.setImageDrawable(car.picture);
        this.mTextCarModel.setText(car.model);

        this.mTextViewDetails.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                listener.onClick(car.id);
            }
        });
    }
}
