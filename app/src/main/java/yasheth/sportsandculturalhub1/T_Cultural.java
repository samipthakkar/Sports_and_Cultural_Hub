package yasheth.sportsandculturalhub1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class T_Cultural extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_cultural_layout);
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    public void onclick(View v){
            if(v.getId()==R.id.btnsolodance)
            {
                Intent i=new Intent(T_Cultural.this,T_Cultural_Indi.class);
                String culture="SOLO DANCING";
                String id="1";
                String desc="Dance is a performance art form consisting of purposefully selected sequences of human movement. This movement has aesthetic and symbolic value, and is acknowledged as dance by performers and observers within a particular culture.Dance can be categorized and described by its choreography, by its repertoire of movements, or by its historical period or place of origin.An important distinction is to be drawn between the contexts of theatrical and participatory dance,[4] although these two categories are not always completely separate; both may have special functions, whether social, ceremonial, competitive, erotic, martial, or sacred/liturgical. Other forms of human movement are sometimes said to have a dance-like quality, including martial arts, gymnastics, figure skating, synchronized swimming and many other forms of athletics.";Bundle b=new Bundle();
                b.putString("CULTURE",culture);
                b.putString("DESC",desc);
                b.putString("ID",id);
                i.putExtras(b);
                startActivity(i);
            }
            else if(v.getId()==R.id.btngroupdance)
            {
                Intent i=new Intent(T_Cultural.this,T_Cultural_Indi.class);
                String culture="GROUP DANCING";
                String id="2";
                String desc="Group dances are danced by groups of people simultaneously, as opposed to individuals dancing alone or individually, and as opposed to couples dancing together but independently of others dancing at the same time, if any.The dances are generally, but not always, coordinated or standardized in such a way that all the individuals in the group are dancing the same steps at the same time. Alternatively, various groups within the larger group may be dancing different, but complementary, parts of the larger dance. An exception to this generalization must be vxpointed out where groups of individuals are dancing independently of each other, but with the purpose of creating a \"group\" feeling or experience, such as might accompany various forms of ritual dancing.";Bundle b=new Bundle();
                b.putString("CULTURE",culture);
                b.putString("DESC",desc);
                b.putString("ID",id);
                i.putExtras(b);
                startActivity(i);
            }
            else if(v.getId()==R.id.btnsinging)
            {
                Intent i=new Intent(T_Cultural.this,T_Cultural_Indi.class);
                String culture="SINGING";
                String id="3";
                String desc="Singing is the act of producing musical sounds with the voice, and augments regular speech by the use of tonality, rhythm, the use of sustained tones and a variety of vocal techniques. A person who sings is called a singer or vocalist. Singers perform music (arias, recitatives, songs, etc.) that can be sung without accompaniment or with accompaniment by musical instruments. Singing is often done in a group of other musicians, such as in a choir of singers with different voice ranges, or in an ensemble with instrumentalists, such as a rock group or baroque ensemble. Singers may also perform as soloist with accompaniment from a piano (as in art song and in some jazz styles) or with a symphony orchestra or big band. There are a range of different singing styles, including art music styles such as opera and Chinese opera, religious music styles such as Gospel, traditional music styles, world music, jazz, blues and popular music styles such as pop and rock.";
                Bundle b=new Bundle();
                b.putString("CULTURE",culture);
                b.putString("DESC",desc);
                b.putString("ID",id);
                i.putExtras(b);
                startActivity(i);
            }
            else if(v.getId()==R.id.btndrama)
            {
                Intent i=new Intent(T_Cultural.this,T_Cultural_Indi.class);
                String culture="DRAMA ";
                String id="4";
                String desc="Drama is the specific mode of narrative, typically fictional, represented in performance.[1] The term comes from the Greek word δρᾶμα meaning to do or to act. The enactment of drama in theatre, performed by actors on a stage before an audience, presupposes collaborative modes of production and a collective form of reception. The structure of dramatic texts, unlike other forms of literature, is directly influenced by this collaborative production and collective reception.";
                Bundle b=new Bundle();
                b.putString("CULTURE",culture);
                b.putString("DESC",desc);
                b.putString("ID",id);
                i.putExtras(b);
                startActivity(i);
            }
            else if(v.getId()==R.id.btnfashion)
            {
                Intent i=new Intent(T_Cultural.this,T_Cultural_Indi.class);
                String culture="FASHION SHOW";
                String id="5";
                String desc="A fashion show is an event put on by a fashion designer to showcase his or her upcoming line of clothing during Fashion Week. Fashion shows debut every season, particularly the Spring/Summer and Fall/Winter seasons. This is where the latest fashion trends are made. The two most influential fashion weeks are Paris Fashion Week and New York Fashion Week, which are both semiannual events. Also, the Milan, London and Berlin are of global importance.[1][2]\n" +
                        "\n" + "In a typical fashion show, models walk the catwalk dressed in the clothing created by the designer. The clothing is illuminated on the runway by the fashion show lighting. The order in which each model walks out wearing a specific outfit is usually planned in accordance to the statement that the designer wants to make about his or her collection. It is then up to the audience to not only try to understand what the designer is trying to say by the way the collection is being presented, but to also visually deconstruct each outfit and try to appreciate the detail and craftsmanship of every single piece.\n" +
                        "\n" + "Occasionally, fashion shows take the form of installations, where the models are static, standing or sitting in a constructed environment. A wide range of contemporary designers tend to produce their shows as theatrical productions with elaborate sets and added elements such as live music or a variety of technological components like holograms, for example.";
                Bundle b=new Bundle();
                b.putString("CULTURE",culture);
                b.putString("DESC",desc);
                b.putString("ID",id);
                i.putExtras(b);
                startActivity(i);
            }
            else if(v.getId()==R.id.btnmusicband)
            {
                Intent i=new Intent(T_Cultural.this,T_Cultural_Indi.class);
                String culture="MUSIC BAND";
                String id="6";
                String desc="A MUSIC BAND also known as a music group, is a group of people who perform instrumental and/or vocal music, with the ensemble typically known by a distinct name. Some music ensembles consist solely of instruments, such as the jazz quartet or the orchestra. Some music ensembles consist solely of singers, such as choirs and doo wop groups. In both popular music and classical music, there are ensembles in which both instrumentalists and singers perform, such as the rock band or the Baroque chamber group for basso continuo (harpsichord and cello) and one or more singers.In classical music, trios or quartets either blend the sounds of musical instrument families (such as piano, strings, and wind instruments) or group together instruments from the same instrument family, such as string ensembles (e.g., string quartet) or wind ensembles (e.g., wind quintet). Some ensembles blend the sounds of a variety of instrument families, such as the orchestra, which uses a string section, brass instruments, woodwinds and percussion instruments, or the concert band, which uses brass, woodwinds and percussion.";
                Bundle b=new Bundle();
                b.putString("CULTURE",culture);
                b.putString("DESC",desc);
                b.putString("ID",id);
                i.putExtras(b);
                startActivity(i);
            }


        }

    }
