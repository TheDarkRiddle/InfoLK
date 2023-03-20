package Graph;
import FakeBlockChain.Queue;
import FakeBlockChain.Stack;
import LagerHaus.List;

public class Navi
{
    Graph mg;
    public Navi()
    {
        mg = new Graph();
        Vertex a = new Vertex ("Aachen");
        Vertex b = new Vertex ("Berlin");
        Vertex c = new Vertex ("Costarica");
        Vertex d = new Vertex ("Düsseldorf");
        Vertex e = new Vertex ("Engelskirchen");
        Vertex f = new Vertex ("Frankfurth");
        Vertex g = new Vertex ("Gummersbach");
        Vertex h = new Vertex ("Hamburg");
        
        mg.addVertex(a);
        mg.addVertex(b);
        mg.addVertex(c);
        mg.addVertex(d);
        mg.addVertex(e);
        mg.addVertex(f);
        mg.addVertex(g);
        mg.addVertex(h);
        
        Edge ab = new Edge (a, b, 4);
        Edge ac = new Edge (a, c, 12);
        Edge ad = new Edge (a, d, 7);
        Edge ag = new Edge (a, g, 10);
        
        Edge bc = new Edge (b, c, 7);
        Edge bf = new Edge (b, f, 8);
        Edge be = new Edge (b, e, 2);
        
        Edge de = new Edge (d, e, 5);
        Edge dg = new Edge (d, g, 8);
        
        Edge gh = new Edge (g, h, 9);
        
        Edge eh = new Edge (e, h, 8);
        Edge ef = new Edge (e, f, 6);
        
        Edge fc = new Edge (f, c, 4);
        Edge fh = new Edge (f, h, 11);
        
        mg.addEdge(ab);
        mg.addEdge(ac);
        mg.addEdge(ad);
        mg.addEdge(ag);
        mg.addEdge(bc);
        mg.addEdge(bf);
        mg.addEdge(be);
        mg.addEdge(de);
        mg.addEdge(dg);
        mg.addEdge(gh);
        mg.addEdge(eh);
        mg.addEdge(ef);
        mg.addEdge(fc);
        mg.addEdge(fh);
    }
    public Vertex TiefenSuche(String start, String ende, Stack<String> sammlung, Graph suchFeld){
        System.out.println(start);
        Vertex startV = suchFeld.getVertex(start);
        Vertex endV = suchFeld.getVertex(ende);
        List<Vertex> tempList;
        if (startV == endV){
            System.out.println("Gefunden!");
            return endV;
        }
        tempList = suchFeld.getNeighbours(startV);
        if (tempList == null){
            return null;
        }
        tempList.toFirst();
        while(tempList.hasAccess()) {
            Vertex tempVertex = tempList.getContent();
            if (!tempVertex.isMarked()){
                tempVertex.setMark(true);
                sammlung.push(tempVertex.getID());
            }
            tempList.next();
        }
        String tempString = sammlung.top();
        sammlung.pop();
        return TiefenSuche(tempString, ende, sammlung, suchFeld);
    }
    public Vertex BreitenSuche(String start, String ende, Queue<String> sammlung, Graph suchFeld){
        System.out.println(start);
        Vertex startV = suchFeld.getVertex(start);
        Vertex endV = suchFeld.getVertex(ende);
        List<Vertex> tempList;
        if (startV == endV){
            System.out.println("Gefunden!");
            return endV;
        }
        tempList = suchFeld.getNeighbours(startV);
        if (tempList == null){
            return null;
        }
        tempList.toFirst();
        while(tempList.hasAccess()) {
            Vertex tempVertex = tempList.getContent();
            if (!tempVertex.isMarked()){
                tempVertex.setMark(true);
                sammlung.enqueue(tempVertex.getID());
            }
            tempList.next();
        }
        String tempString = sammlung.front();
        sammlung.dequeue();
        return BreitenSuche(tempString, ende, sammlung, suchFeld);
    }
    public void MakeVertex(String name, int wieght){


    }
    public static void main(String[] args) {
    Stack<String> einStingStack = new Stack<String>();
    Queue<String> eineStringQueu = new Queue<>();
    Navi einNavi = new Navi();
    einNavi.mg.setAllVertexMarks(false);
    einNavi.mg.setAllEdgeMarks(false);
    Vertex Berlin = einNavi.mg.getVertex("Berlin");
    Vertex Gummersbach = einNavi.mg.getVertex("Gummersbach");
    Vertex ergebniss = einNavi.TiefenSuche(Berlin.getID(), Gummersbach.getID(), einStingStack, einNavi.mg);
    if (ergebniss != null){
        System.out.println("Gefunden:" + ergebniss);
    }
    else{
        System.out.println("Nothing");
    }
        einNavi.mg.setAllVertexMarks(false);
        einNavi.mg.setAllEdgeMarks(false);
    ergebniss = einNavi.BreitenSuche(Berlin.getID(),Gummersbach.getID(), eineStringQueu, einNavi.mg);
        if (ergebniss != null){
            System.out.println("Gefunden:" + ergebniss);
        }
        else{
            System.out.println("Nothing");
        }
    }
}
