package yasheth.sportsandculturalhub1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;


public class S_Sports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_sports_layout);
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    public void onclick(View v){
        if(v.getId()==R.id.btnfootball)
        {
            Intent i=new Intent(S_Sports.this,S_Sports_Indi.class);
            String sport="FOOTBALL";
            String id="1";
            String desc="Association football, more commonly known as football or soccer, is a sport played between two teams of eleven players with a spherical ball. It is played by 250 million players in over 200 nations, making it the world\\'s most popular sport. The game is played on a rectangular field with a goal at each end. The object of the game is to score by getting the ball into the opposing goal.\n" +
                    "The goalkeepers are the only players allowed to touch the ball with their hands or arms while it is in play and only in their penalty area. Outfield players mostly use their feet to strike or pass the ball, but may also use their head or torso to do so instead. The team that scores the most goals by the end of the match wins. If the score is level at the end of the game, either a draw is declared or the game goes into extra time and/or a penalty shootout depending on the format of the competition. The Laws of the Game were originally codified in England by The Football Association in 1863. Association football is governed internationally by the International Federation of Association Football (FIFA; French: Fédération Internationale de Football Association), which organises World Cups for both men and women every four years.";
            Bundle b=new Bundle();
            b.putString("SPORT",sport);
            b.putString("DESC",desc);
            b.putString("ID",id);
            i.putExtras(b);
            startActivity(i);
        }
        else if(v.getId()==R.id.btntabletennis)
        {
            Intent i=new Intent(S_Sports.this,S_Sports_Indi.class);
            String sport="TABLE TENNIS";
            String id="2";
            String desc="Table tennis, also known as ping pong, is a sport in which two or four players hit a lightweight ball back and forth across a table using a small paddle. The game takes place on a hard table divided by a net. Except for the initial serve, the rules are generally as follows: Players must allow a ball played toward them to bounce one time on their side of the table, and must return it so that it bounces on the opposite side at least once. Points are scored when a player fails to return the ball within the rules. Play is fast and demands quick reactions. Spinning the ball alters its trajectory and limits an opponent's options, giving the hitter a great advantage. When doing so the hitter has a better chance of scoring if the spin is successful.\n" +
                    "Table tennis is governed by the worldwide organization International Table Tennis Federation, founded in 1926. ITTF currently includes 220 member associations The table tennis official rules are specified in the ITTF handbook. Table tennis has been an Olympic sport since 1988,[3] with several event categories. In particular, from 1988 until 2004, these were: men's singles, women's singles, men's doubles and women's doubles. Since 2008, a team event has been played instead of the doubles.\n";
            Bundle b=new Bundle();
            b.putString("SPORT",sport);
            b.putString("DESC",desc);
            b.putString("ID",id);
            i.putExtras(b);
            startActivity(i);
        }
        else if(v.getId()==R.id.btncricket)
        {
            Intent i=new Intent(S_Sports.this,S_Sports_Indi.class);
            String sport="CRICKET";
            String id="3";
            String desc="Cricket is a bat-and-ball game played between two teams of 11 players each on a field at the centre of which is a rectangular 22-yard-long pitch. The game is played by 120 million players in many countries, making it the world's second most popular sport after association football. Each team takes its turn to bat, attempting to score runs, while the other team fields. Each turn is known as an innings (used for both singular and plural).\n" +
                    "The bowler delivers the ball to the batsman who attempts to hit the ball with his bat away from the fielders so he can run to the other end of the pitch and score a run. Each batsman continues batting until he is out. The batting team continues batting until ten batsmen are out, or a specified number of overs of six balls have been bowled, at which point the teams switch roles and the fielding team comes in to bat.\n" +
                    "In professional cricket, the length of a game ranges from 20 overs (T20) per side to Test cricket played over five days. The Laws of Cricket are maintained by the International Cricket Council (ICC) and the Marylebone Cricket Club (MCC) with additional Standard Playing Conditions for Test matches and One Day Internationals.\n" +
                    "Cricket is generally believed to have been first played in southern England in the 16th century. By the end of the 18th century, it had become the national sport of England. The expansion of the British Empire led to cricket being played overseas and by the mid-19th century the first international match was held. ICC, the game's governing body, has 10 full members. The game is most popular in Australasia, England, the Indian subcontinent, the West Indies and Southern Africa.\n";
            Bundle b=new Bundle();
            b.putString("SPORT",sport);
            b.putString("DESC",desc);
            b.putString("ID",id);
            i.putExtras(b);
            startActivity(i);
        }
        else if(v.getId()==R.id.btnbasketball)
        {
            Intent i=new Intent(S_Sports.this,S_Sports_Indi.class);
            String sport="BASKETBALL";
            String id="4";
            String desc="Basketball is a sport played by two teams of five players on a rectangular court. The objective is to shoot a ball through a hoop 18 inches (46 cm) in diameter and 10 feet (3.048 m) high mounted to a backboard at each end. Basketball is one of the world's most popular and widely viewed sports.\n" +
                    "The National Basketball Association (NBA) is the most popular and widely considered to be the highest level of professional basketball in the world and NBA players are the world's best paid sportsmen, by average annual salary per player. Outside North America, the top clubs from national leagues qualify to continental championships such as the Euroleague and FIBA Americas League. The FIBA Basketball World Cup attracts the top national teams from around the world. Each continent hosts regional competitions for national teams, like EuroBasket and FIBA Americas Championship.\n" +
                    "Women's basketball is less popular than men's. The FIBA Women's Basketball World Cup features the top national teams from continental championships. The main North American league is the WNBA, whereas the EuroLeague Women has been dominated by teams from the Russian Women's Basketball Premier League.\n";
            Bundle b=new Bundle();
            b.putString("SPORT",sport);
            b.putString("DESC",desc);
            b.putString("ID",id);
            i.putExtras(b);
            startActivity(i);
        }
        else if(v.getId()==R.id.btntennis)
        {
            Intent i=new Intent(S_Sports.this,S_Sports_Indi.class);
            String sport="LAWN TENNIS";
            String id="5";
            String desc="Tennis is a racket sport that can be played individually against a single opponent (singles) or between two teams of two players each (doubles). Each player uses a tennis racket that is strung with cord to strike a hollow rubber ball covered with felt over or around a net and into the opponent's court. The object of the game is to play the ball in such a way that the opponent is not able to play a valid return. The player who is unable to return the ball will not gain a point, while the opposite player will.\n" +
                    "The rules of tennis have changed little since the 1890s. Two exceptions are that from 1908 to 1961 the server had to keep one foot on the ground at all times, and the adoption of the tiebreak in the 1970s. A recent addition to professional tennis has been the adoption of electronic review technology coupled with a point challenge system, which allows a player to contest the line call of a point.\n" +
                    "Tennis is played by millions of recreational players and is also a popular worldwide spectator sport. The four Grand Slam tournaments (also referred to as the \"Majors\") are especially popular: the Australian Open played on hard courts, the French Open played on red clay courts, Wimbledon played on grass courts, and the US Open played also on hard courts.\n";
            Bundle b=new Bundle();
            b.putString("SPORT",sport);
            b.putString("DESC",desc);
            b.putString("ID",id);
            i.putExtras(b);
            startActivity(i);
        }
        else if(v.getId()==R.id.btnvolleyball)
        {
            Intent i=new Intent(S_Sports.this,S_Sports_Indi.class);
            String sport="VOLLEYBALL";
            String id="6";
            String desc="Volleyball is a team sport in which two teams of six players are separated by a net. Each team tries to score points by grounding a ball on the other team's court under organized rules. It has been a part of the official program of the Summer Olympic Games since 1964.\n" +
                    "The complete rules are extensive. But simply, play proceeds as follows: a player on one of the teams begins a 'rally' by serving the ball (tossing or releasing it and then hitting it with a hand or arm), from behind the back boundary line of the court, over the net, and into the receiving team's court. The receiving team must not let the ball be grounded within their court. The team may touch the ball up to 3 times but individual players may not touch the ball twice consecutively. Typically, the first two touches are used to set up for an attack, an attempt to direct the ball back over the net in such a way that the serving team is unable to prevent it from being grounded in their court.\n" +
                    "The rally continues, with each team allowed as many as three consecutive touches, until either (1): a team makes a kill, grounding the ball on the opponent's court and winning the rally; or (2): a team commits a fault and loses the rally. The team that wins the rally is awarded a point, and serves the ball to start the next rally.\n";
            Bundle b=new Bundle();
            b.putString("SPORT",sport);
            b.putString("DESC",desc);
            b.putString("ID",id);
            i.putExtras(b);
            startActivity(i);
        }


    }
}
