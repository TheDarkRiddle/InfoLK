package Ahnenbaum;

public class Stammbaum<T>{
    BinaryTree<T> Wortel;
    public Stammbaum(BinaryTree<T> a){
        Wortel = a;
    }

    public T GibAus(BinaryTree<T> tree){
        if(tree.getLeftTree().isEmpty() && tree.getRightTree().isEmpty()){
            return tree.getContent();
        }
        if (!tree.getRightTree().isEmpty() && !tree.getLeftTree().isEmpty()){
            return GibAus(tree.getLeftTree()) + GibAus(tree.getRightTree());
        }
        if (tree.getRightTree().isEmpty()){
           return GibAus(tree.getLeftTree());
        }
        else {
            return GibAus(tree.getRightTree());
        }
    }


    public static void main(String[] args) {
        BinaryTree<String> Gen2_4 = new BinaryTree<>("Erhard");
        BinaryTree<String> Gen2_3 = new BinaryTree<>("Christine");
        BinaryTree<String> Gen2_2 = new BinaryTree<>("Wolfgang");
        BinaryTree<String> Gen2 = new BinaryTree<>("Heidi");
        BinaryTree<String> Gen1_2 = new BinaryTree<>("Matthias", Gen2_3, Gen2_4);
        BinaryTree<String> Gen1 = new BinaryTree<>("Mellanie", Gen2,Gen2_2);
        BinaryTree<String> Gen0 = new BinaryTree<>("Moritz", Gen1, Gen1_2);
        Stammbaum<String> StringBaum = new Stammbaum<>(Gen0);
        System.out.println(StringBaum.GibAus(StringBaum.Wortel));

    }
}
