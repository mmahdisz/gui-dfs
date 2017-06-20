/**
 * Created by Mehdi on 20/06/2017.
 */

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Scanner;
public class Main extends Application {


    static int Nod;
    static int Edg;
    static Circle n[];
    static Text label[];
    static Line connect[];
    static Sorted sor;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        n[0] = new Circle(395,45,20,Color.BLACK);
        for (int i = 1; i < Nod; i++) {

            label[i] = new Text(n[i].getCenterX()-5 ,n[i].getCenterY() + 5, (i+1) + "");
            label[i].setFill(Color.WHITE);
        }
        label[0] = new Text(395,45,"1");
        label[0].setFill(Color.WHITE);

        for (int i = 0; i < Edg; i++) {
            root.getChildren().add(connect[i]);
        }

        for (int i = 0; i < Nod ; i++) {
            root.getChildren().add(n[i]);
            root.getChildren().add(label[i]);
        }

        FillTransition anime[] = new FillTransition[Nod];
        for (int i = 0 ; i < Nod ; i++){
            anime[i] = new FillTransition(Duration.seconds(2));
            anime[i].setShape(n[sor.get() - 1]);
            anime[i].setToValue(Color.GOLD);
            anime[i].setAutoReverse(false);
        }
        anime[0].play();
        for (int i = 1 ; i < Nod ; i++){
            int finalI = i;
            anime[i - 1].setOnFinished(e -> anime[finalI].play());

        }

        Scene sce = new Scene(root,800,800,Color.WHITE);
        primaryStage.setTitle("DFS");
        primaryStage.setScene(sce);


        primaryStage.show();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Nodes: ");
        int nodes = in.nextInt();
        Nod = nodes;

        n = new Circle[Nod];
        label = new Text[Nod];

        Vertex[] vertex = new Vertex[nodes];

        for (int i = 0 ; i < nodes ; i++){
            vertex[i] = new Vertex((i+1)+"");
        }


        System.out.println("Edges: ");
        int edges = in.nextInt();

        Edg = edges;

        connect = new Line[Edg];

        // JAVAFX Base:

        n[0] = new Circle(400,40,20,Color.BLACK);


        for (int i = 1; i < Nod ; i++) {
            n[i] = new Circle(Math.random()*700  + 50, Math.random()*700  + 80 , 20,Color.BLACK );
        }

        System.out.println("Make Link Like 2 3");
        for (int i = 0 ; i < edges ; i++){
            int s = in.nextInt();
            int e = in.nextInt();
            vertex[s - 1].makeChild( vertex[e - 1] );

            connect[i] = new Line(n[ s - 1 ].getCenterX(),n[s - 1].getCenterY(),n[ e - 1 ].getCenterX(),n[e - 1].getCenterY());
        }
        sor = new Sorted(Nod);
        DFS main = new DFS();
        main.run(vertex[0], sor);

        launch(args);
    }
}
