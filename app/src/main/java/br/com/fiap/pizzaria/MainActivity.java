package br.com.fiap.pizzaria;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.fiap.pizzaria.model.ConfirmarPedidoActivity;
import br.com.fiap.pizzaria.model.Pedido;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cbBacon)
    CheckBox cbBacon;

    @BindView(R.id.cbAtum)
    CheckBox cbAtum;

    @BindView(R.id.rgTamanho)
    RadioGroup rgTamanho;

    @BindView(R.id.spPagamentos)
    Spinner spPagamentos;

    @BindView(R.id.tvCliente)
    TextView tvCliente;

    private String nomeUsusario;

    Pedido pedido = new(pedido);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent() != null){
            nomeUsusario = getIntent().getStringExtra("USUARIO");
        }



        cbBacon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    pedido.addSabor(cbBacon.getText().toString());

            }else{
                    pedido.removerSabor(cbBacon.getText().toString());
                }
        });

    }

    @OnClick(R.id.btFecharPedido)
    public void fecharPedido(){

        pedido.setCliente(nomeUsusario);
        pedido.setTamanho(getTamanhoSelecionado());
        pedido.setFormaPagamento(spPagamentos.getSelectedItem().toString());

        Intent i = new Intent(this, ConfirmarPedidoActivity.class);
            i.putExtra("PEDIDO",pedido);
            startActivity(i);

    }

     public String getTamanhoSelecionado(){
        switch (rgTamanho.getCheckedRadioButtonId()){

            return ((RadioButton)findViewById(R.id.rbBroto)).getText().toString();


    }


}
