package com.spartakdebruguers.ofapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.spartakdebruguers.ofapp.R;
import com.spartakdebruguers.ofapp.database.DBHelper;
import com.spartakdebruguers.ofapp.model.News;
import com.spartakdebruguers.ofapp.utils.ConfigUtils;

public class NewsDetailsActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_layout);

        // get the details
        Intent intent = getIntent();
        News details = new News();
        details.setImageURL(intent.getStringExtra(DBHelper.COLUMN_NEWS_IMG_URL));
        details.setTitle(intent.getStringExtra(DBHelper.COLUMN_NEWS_TITLE));
        details.setHeader(intent.getStringExtra(DBHelper.COLUMN_NEWS_HEADER));
        details.setContent(intent.getStringExtra(DBHelper.COLUMN_NEWS_CONTENT));

        String mierda ="Foto de archivo de parte del equipo de <strong>The Pink Panter</strong> despu&eacute;s de la primera falta de <strong>Manu</strong>. Pese a perder contra los subcampeones de liga, seguimos con un 99% de posibilidades de clasificarnos para la <strong>Champions</strong> gracias a que <strong>Hombres de Vitrubio</strong> no se present&oacute; con suficientes jugadores al partido ante <strong>Fueguito</strong> y que ya han insinuado que se dejar&aacute;n ganar el &uacute;ltimo partido, cambi&aacute;ndose el nombre a <strong>Mujeres de Vitrubio</strong> y dando la raz&oacute;n a <strong>Dani</strong> y a <strong>Javi</strong>. De nuevo cont&aacute;bamos con la baja de <strong>&Aacute;lex</strong> por segundo partido consecutivo pero la suplimos con otro gran peso del vestuario que volv&iacute;a despu&eacute;s de cuatro meses: <strong>Iv&aacute;n</strong>.</p>\n" +
                "<p>El partido comenz&oacute; cuando <strong>Pink Panter</strong> solo presentaban cinco jugadores. Un partido limpio, con idas y venidas de por parte de los dos equipos. De hecho creo que fue el partido en el que con m&aacute;s claridad hemos llegado. Pero como eso de empezar ganando no se nos da muy bien, encajamos el primer gol en el &uacute;nico fallo que tuvimos en defensa, dejando un jugador solo en el segundo palo que marc&oacute; a un pase desde la l&iacute;nea de fondo. La respuesta fue inmediata y es que nada m&aacute;s sacar y tras un regate magistral de <strong>JC</strong>, <strong>Dani</strong> aprovechaba su asistencia para marcar casi a placer. Despu&eacute;s del gol entraron en juego los jugadores que tuvieron sus rifi-rafes con <strong>Manu</strong> en anteriores partidos y no tardaron en liarla. Tras la primera falta de <strong>Manu</strong>, vino una agresi&oacute;n en toda regla de <strong>The Pink Panter</strong>, pegando una patada por detr&aacute;s a <strong>Manu</strong> sin la pelota en juego que incomprensiblemente fue sancionada con amarilla. Luego continuaron los improperios varios, dos tarjetas amarillas por hablar y una estampaci&oacute;n contra el muro<strong> &ldquo;made in Manu&rdquo;</strong>. A&uacute;n pudimos marcar el segundo con un cabezazo-vaselina de <strong>Dani</strong>, que dio en el larguero y bot&oacute; sobre la l&iacute;nea. Con ese percal y los ni&ntilde;os como <strong>Gremlings</strong> en celo acab&oacute; la primera parte.</p>" +
                "<p>En la segunda <strong>Manu</strong> decidi&oacute; no jugar para no acabar pegando a los ni&ntilde;os. Eso unido a <strong>Jes&uacute;s</strong> reca&iacute;do nos hac&iacute;a agotarnos. Aun as&iacute; ten&iacute;amos jugadas continuas pero no &eacute;ramos capaces de meter la pierna para meter el bal&oacute;n. Misma jugada una y otra vez, pase cruzado que sobrepasaba la defensa pero no llegamos al segundo palo. <strong>The Pink Panter</strong> no tard&oacute; en aprovechar su superioridad y nos marc&oacute; tres goles m&aacute;s, uno en un uno contra uno y dos despu&eacute;s de jugada personal.</p>" +
                "<p>Hasta aqu&iacute; la liga regular del <strong>Spartak</strong> que acaba en una meritoria cuarta plaza y siendo el tercer equipo menos goleado pese a las lesiones que hemos sufrido. Hemos demostrado que jugando bien podemos plantar cara a cualquiera. Ser&aacute; dif&iacute;cil ganar a <strong>Drink Team</strong>, pero con su juego noble y con una buena defensa podemos llegar a semifinales. Ahora a recuperarnos y a pensar en la <strong>Champions</strong>.<strong> &iexcl;FOR&Ccedil;A SPARTAK!</strong></p>";

        // show the image
        try {
            ImageLoader.getInstance()
                    .displayImage(details.getImageURL(), ((ImageView) findViewById(R.id.news_detail_image)));
        } catch(Exception ex ){
            ConfigUtils.configImageLoader(getApplicationContext());
            ImageLoader.getInstance()
                    .displayImage(details.getImageURL(), ((ImageView) findViewById(R.id.news_detail_image)));
        }

        ((TextView) findViewById(R.id.news_detail_title)).setText(details.getTitle()); // set the title
        ((TextView) findViewById(R.id.news_detail_subtitle)).setText(details.getHeader()); // set the header
        ((TextView) findViewById(R.id.news_detail_creation)).setText("Javi, 10/10/2014"); // set the creation date
        ((TextView) findViewById(R.id.news_detail_content)).setText(Html.fromHtml(mierda)); // set the content
    }
}
