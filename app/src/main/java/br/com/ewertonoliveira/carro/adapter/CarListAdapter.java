package br.com.ewertonoliveira.carro.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.ewertonoliveira.carro.R;
import br.com.ewertonoliveira.carro.entities.Car;
import br.com.ewertonoliveira.carro.listener.OnListClickInterationListener;
import br.com.ewertonoliveira.carro.viewholder.CarViewHolder;

public class CarListAdapter extends RecyclerView.Adapter<CarViewHolder> {

    private List<Car> mListCars;
    private OnListClickInterationListener mOnListClickInterationListener;


    public CarListAdapter(List<Car> cars, OnListClickInterationListener listener) {
        this.mListCars = cars;
        this.mOnListClickInterationListener = listener;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View carView = inflater.inflate(R.layout.row_car_list, parent, false);

        return new CarViewHolder(carView);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        Car car = this.mListCars.get(position);
        holder.bindData(car, this.mOnListClickInterationListener);
    }

    @Override
    public int getItemCount() {
        return this.mListCars.size();
    }
}
