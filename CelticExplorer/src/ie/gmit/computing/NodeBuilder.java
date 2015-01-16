package ie.gmit.computing;

import java.io.*;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class NodeBuilder extends ActionBarActivity
{
	/*public void getRootNode(View view, Node currentNode)
	{
		Intent intent = new Intent(this, DynamicButton.class);
		Node currentNode = New Node()
	}*/
	
	/**
	 * This populates the tree node class with information
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		Node root = new Node("Begining", null);
		
		Node solid = new Node("Soild", root);
		root.addChild(solid);
		
		Node flexible = new Node("Flexible", root);
		root.addChild(flexible);
		
		Node hard = new Node("Hard", solid);
		root.addChild(hard);
		
		Node squashed = new Node("Squashed", solid);
		root.addChild(squashed);
		
		Node fib = new Node("Fibmentous", flexible);
		root.addChild(fib);
		
		Node lorse = new Node("Lorse", flexible);
		root.addChild(lorse);
		
		Node smoothEdge = new Node("Smooth Edge", hard);
		root.addChild(smoothEdge);		
		
		Node irregEdge = new Node("Irregular Edges", hard);
		root.addChild(irregEdge);
		
		Node styrene = new Node("Styrene", squashed);
		root.addChild(styrene);
		
		Node fibre = new Node("Fibre", fib);
		root.addChild(fibre);
		//code for picture
		
		Node film = new Node("Film", lorse);
		root.addChild(film);
		//code for the picture		
		
		Node resin = new Node("Resin Pellet", smoothEdge);
		root.addChild(resin);
		
		Node fragOfLarge = new Node("Fragment Of Large Item",irregEdge);
		root.addChild(fragOfLarge);
		
		Node cylin = new Node("Cylindracle", resin);
		root.addChild(cylin);
		
		Node round = new Node("Rounded", resin);
		root.addChild(round);
		
		Node longC = new Node("Long", cylin);
		root.addChild(longC);
		//picture code here
		
		Node flat = new Node("Flat", cylin);
		root.addChild(flat);
		//picture code here
		
		Node oval = new Node("Oval", round);
		root.addChild(oval);
		
		Node sphere = new Node("Sphere", round);
		root.addChild(sphere);
		
		Node edges = new Node("Edges", round);
		root.addChild(edges);
		
		Node allAng = new Node("All Angular", edges);
		root.addChild(allAng);
		
		Node mostAng = new Node("Most Angular", edges);
		root.addChild(mostAng);
		
		Node allRound = new Node("All Round", edges);
		root.addChild(allRound);
		
		Node mostRound = new Node("Most Round", edges);
		root.addChild(mostRound);
		
		//getRootNode(root);
		
		/**
		 * The function to write/read the desision tree out to file call "desTree"
		 */
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("desTree.ser"));
		out.writeObject(root);
		out.flush();
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("desTree.ser")));		
		root = (Node) in.readObject();
		System.out.println(root.getName());
	}
	
	
}
