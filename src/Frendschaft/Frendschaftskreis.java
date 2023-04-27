package Frendschaft;
public class Frendschaftskreis {

    private Graph FRK = new Graph();
    private Vertex Susi = new Vertex("Susi");
    private Vertex Karl = new Vertex("Karl");
    private Vertex Lisa = new Vertex("Lisa");
    private Vertex Jens = new Vertex("Jens");
    private Vertex Merle = new Vertex("Merle");

    private Edge SK = new Edge(Susi, Karl, 1);
    private Edge SL = new Edge(Susi, Lisa, 1);
    private Edge SM = new Edge(Susi, Merle, 1);

    private Edge KL = new Edge(Karl, Lisa, 1);
    private Edge KM = new Edge(Karl, Merle, 1);
    private Edge KS = new Edge(Karl, Susi, 1);
    private Edge KJ = new Edge(Karl, Jens, 1);

    private Edge LK = new Edge(Lisa, Karl, 1);
    private Edge LM = new Edge(Lisa, Merle, 1);
    private Edge LS = new Edge(Lisa, Susi, 1);

    private Edge JK = new Edge(Jens, Karl,1);

    private Edge MK = new Edge(Merle, Karl, 1);
    private Edge ML = new Edge(Merle, Lisa, 1);
    private Edge MS = new Edge(Merle, Susi, 1);

    FRK.addVertex(Sus);
    FRK.addVertex();
    FRK.addVertex();
    FRK.addVertex();
    FRK.addVertex();


}
