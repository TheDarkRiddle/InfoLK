package Ahnenbaum;

public class Stammbaum<T>{
    BinaryTree<T> Wortel;
    public Stammbaum(BinaryTree<T> a){
        Wortel = a;
    }

    public void GibAus(BinaryTree<T> tree, String space){
        if(!tree.isEmpty()){
            System.out.println(tree.getContent()+space);
        }
        BinaryTree<T> left = tree.getLeftTree();
        if(!left.isEmpty()){
            GibAus(left, space+"  ");
        }
        BinaryTree<T> right = tree.getRightTree();
        if(!right.isEmpty()){
            GibAus(right, space+"  ");
        }

    }
    public String GibAusTwo(BinaryTree<T> tree, String space){
        BinaryTree<T> left = tree.getLeftTree();
        BinaryTree<T> right = tree.getRightTree();
        if (!left.isEmpty() && !right.isEmpty()){
            return tree.getContent().toString() + space
                    + GibAusTwo(left, space+" ") + space
                    + GibAusTwo(right, space+" ") + space;
        }
            if (!left.isEmpty()) {
                return tree.getContent().toString() + GibAusTwo(left, space +" ") + space;
            }
            if (!right.isEmpty()) {
                return tree.getContent().toString() + GibAusTwo(right, space +" ") + space;
            }
        return tree.getContent().toString();
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
        StringBaum.GibAus(StringBaum.Wortel, " ");
       System.out.println(StringBaum.GibAusTwo(StringBaum.Wortel, " "));
    }
}
