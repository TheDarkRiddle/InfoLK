package Ahnenbaum;

public class AVLTree<ContentType> {
    /**
     * <p>
     * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2017.
     * </p>
     * <p>
     * Generische Klasse AVLTree<ContentType>
     * </p>
     * <p>
     * Mithilfe der generischen Klasse AVLTree koennen beliebig viele
     * Inhaltsobjekte vom Typ ContentType in einem Binaerbaum verwaltet werden. Ein
     * Objekt der Klasse stellt entweder einen leeren Baum dar oder verwaltet ein
     * Inhaltsobjekt sowie einen linken und einen rechten Teilbaum, die ebenfalls
     * Objekte der generischen Klasse AVLTree sind.
     * </p>
     *
     * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule;
     *         Materialien zum schulinternen Lehrplan Informatik SII
     * @version Generisch_04 2020-03-11
     */
        /* --------- Anfang der privaten inneren Klasse -------------- */

        /**
         * Durch diese innere Klasse kann man dafuer sorgen, dass ein leerer Baum null
         * ist, ein nicht-leerer Baum jedoch immer eine nicht-null-Wurzel sowie
         * nicht-null-Teilbaeume, ggf. leere Teilbaeume hat.
         */
        private class BTNode {

            private ContentType content;
            private int height;
            private AVLTree<ContentType> left, right;

            private BTNode(ContentType pContent) {
                // Der Knoten hat einen linken und einen rechten Teilbaum, die
                // beide von null verschieden sind. Also hat ein Blatt immer zwei
                // leere Teilbaeume unter sich.
                //Der Knoten besitz eine Höhe, welche pflicht ist
                this.content = pContent;
                height = 0;
                left = new AVLTree<ContentType>();
                right = new AVLTree<ContentType>();
            }

        }

        /* ----------- Ende der privaten inneren Klasse -------------- */

        private BTNode node;

        /**
         * Nach dem Aufruf des Konstruktors existiert ein leerer Binaerbaum.
         */
        public AVLTree() {
            this.node = null;
        }

        /**
         * Wenn der Parameter pContent ungleich null ist, existiert nach dem Aufruf des
         * Konstruktors der Binaerbaum und hat pContent als Inhaltsobjekt und zwei leere
         * Teilbaeume. Falls der Parameter null ist, wird ein leerer Binaerbaum erzeugt.
         *
         * @param pContent das Inhaltsobjekt des Wurzelknotens vom Typ ContentType
         */
        public AVLTree(ContentType pContent) {
            if (pContent != null) {
                this.node = new BTNode(pContent);
            } else {
                this.node = null;
            }
        }

        /**
         * Wenn der Parameter pContent ungleich null ist, wird ein Binaerbaum mit
         * pContent als Inhalt und den beiden Teilbaeumen pLeftTree und pRightTree
         * erzeugt. Sind pLeftTree oder pRightTree gleich null, wird der entsprechende
         * Teilbaum als leerer Binaerbaum eingefuegt. So kann es also nie passieren,
         * dass linke oder rechte Teilbaeume null sind. Wenn der Parameter pContent
         * gleich null ist, wird ein leerer Binaerbaum erzeugt.
         *
         * @param pContent   das Inhaltsobjekt des Wurzelknotens vom Typ ContentType
         * @param pLeftTree  der linke Teilbaum vom Typ AVLTree<ContentType>
         * @param pRightTree der rechte Teilbaum vom Typ AVLTree<ContentType>
         */
        public AVLTree(ContentType pContent, AVLTree<ContentType> pLeftTree, AVLTree<ContentType> pRightTree) {
            if (pContent != null) {
                this.node = new BTNode(pContent);
                if (pLeftTree != null) {
                    this.node.left = pLeftTree;
                } else {
                    this.node.left = new AVLTree<ContentType>();
                }
                if (pRightTree != null) {
                    this.node.right = pRightTree;
                } else {
                    this.node.right = new AVLTree<ContentType>();
                }
                updateHeight(this.node);
               node = rebalance(this.node);
            } else {
                // Da der Inhalt null ist, wird ein leerer BinarySearchTree erzeugt.
                this.node = null;
            }
        }

         /**
          * Diese Anfrage liefert den Hoehenwert der Node, sovern diese nicht Null ist
          * Tipp! Google Elvis-Operrator
          * Ausdruck ?(Elvis-Operrator) WennTrue : WennFalse
          *
          * @param treePart die Überreichte Node
          * @return die Hoehe der Node, wenn es keine Node gibt, wird -1 returnt.
          */
        private int getHeight(BTNode treePart){
            return treePart != null ? treePart.height : -1;
        }

         /**
          * Diese Methode aktualiesiert den Hoehenwert der Node
          * max(a,b) +1 liefert den höheren wert, entweder a oder b, +1
          *
          * @param treePart die Überreichte Node
          */
        private void updateHeight(BTNode treePart){
            int leftChildHeight = getHeight(treePart.left.node);
            int rightChildHeight = getHeight(treePart.right.node);
            treePart.height = Math.max(leftChildHeight, rightChildHeight) +1;
        }
        /**
         * Diese Methode liefert den Balance Faktor eines Knotens
         * @return der Balance Faktor
         */
        private int balanceFactor(BTNode treePart){
            return getHeight(treePart.right.node) -getHeight(treePart.left.node);
        }

        /**
         * Diese Anfrage liefert den Wahrheitswert true, wenn der Binaerbaum leer ist,
         * sonst liefert sie den Wert false.
         *
         * @return true, wenn der Binaerbaum leer ist, sonst false
         */
        public boolean isEmpty() {
            return this.node == null;
        }

         /**
          * Dieser Dienst führt eine rechts Rotation durch
          * dem Linken Teilbaum, des überreichten Baums wird der Linken Teilbaums des Teilbaums(treePart) zu geschrieben
          * Welcher wiederrum den Ehemailgen(seinen Vorgänger) Linken Teilbaum als Rechten TeilBaum zugewiesen bekommt
          *
          * @param treePart die Überreichte Node
          * @return den neuen Höchsten/zusammengesetzten Baum
          */
        private BTNode rotateRight(BTNode treePart){
            BTNode leftChild = treePart.left.node;

            treePart.left = leftChild.right;
            leftChild.right.node = treePart;

            updateHeight(treePart);
            updateHeight(leftChild);
            return leftChild;
        }

        /**
         * Dieser Dienst führt eine links Rotation durch
         * dem Rechten Teilbaum, des überreichten Baums wird der Rechte Teilbaum des Teilbaums(treePart) zu geschrieben
         * Welcher wiederrum den Ehemailgen(seinen Vorgänger) Rechten Teilbaum als Linken TeilBaum zugewiesen bekommt
         *
         * @param treePart die Überreichte Node
         * @return den neuen Höchsten/zusammengesetzten Baum
         */
        private BTNode rotateLeft(BTNode treePart){
            BTNode rightChild = treePart.right.node;

            node.right = rightChild.left;
            rightChild.left.node = treePart;

            updateHeight(treePart);
            updateHeight(rightChild);

            return rightChild;
        }


        /**
         * Diese Methode prüft ob der Balancfavtor des Baumes Korrekt ist, und wenn nicht, wird durch
         * eine entsprechenden Rotation der Balance Faktor wieder Koriegert
         * @param treePart die Überreichte Node
         * @return der Gebalancte Teilbaum
         *
         */

    private BTNode rebalance(BTNode treePart) {
        int balanceFactor = balanceFactor(treePart);

        // Left-heavy?
        if (balanceFactor < -1) {
            if (balanceFactor(treePart.left.node) <= 0) {    // Case 1
                // Rotate right
                treePart = rotateRight(treePart);
            } else {                                // Case 2
                // Rotate left-right
                BTNode tempTree = rotateLeft(treePart.right.node);
                treePart.left.node = tempTree;
                treePart = rotateRight(treePart);
            }
        }

        // Right-heavy?
        if (balanceFactor > 1) {
            if (balanceFactor(treePart.right.node) >= 0) {    // Case 3
                // Rotate left
                treePart = rotateLeft(treePart);
            } else {                                 // Case 4
                // Rotate right-left
                BTNode tempTree = rotateRight(treePart.right.node);
                treePart.right.node = tempTree;
                treePart = rotateLeft(treePart);
            }
        }

        return treePart;
    }
        /**
         * Wenn pContent null ist, geschieht nichts. <br />
         * Ansonsten: Wenn der Binaerbaum leer ist, wird der Parameter pContent als
         * Inhaltsobjekt sowie ein leerer linker und rechter Teilbaum eingefuegt. Ist
         * der Binaerbaum nicht leer, wird das Inhaltsobjekt durch pContent ersetzt. Die
         * Teilbaeume werden nicht geaendert.
         *
         * @param pContent neues Inhaltsobjekt vom Typ ContentType
         */
        public void setContent(ContentType pContent) {
            if (pContent != null) {
                if (this.isEmpty()) {
                    node = new BTNode(pContent);
                    this.node.left = new AVLTree<ContentType>();
                    this.node.right = new AVLTree<ContentType>();
                    updateHeight(node);
                    node = rebalance(node);
                }
                this.node.content = pContent;
            }
        }

        /**
         * Diese Anfrage liefert das Inhaltsobjekt des Binaerbaums. Wenn der Binaerbaum
         * leer ist, wird null zurueckgegeben.
         *
         * @return das Inhaltsobjekt der Wurzel vom Typ ContentType bzw. null, wenn der
         *         Binaerbaum leer ist
         */
        public ContentType getContent() {
            if (this.isEmpty()) {
                return null;
            } else {
                return this.node.content;
            }
        }

        /**
         * Falls der Parameter null ist, geschieht nichts. Wenn der Binaerbaum leer ist,
         * wird pTree nicht angehaengt. Andernfalls erhaelt der Binaerbaum den
         * uebergebenen AVLTree als linken Teilbaum.
         *
         * @param pTree neuer linker Teilbaum vom Typ AVLTree<ContentType>
         */
        public void setLeftTree(AVLTree<ContentType> pTree) {
            if (!this.isEmpty() && pTree != null) {
                this.node.left = pTree;
                updateHeight(node);
                node = rebalance(node);
            }
        }

        /**
         * Falls der Parameter null ist, geschieht nichts. Wenn der Binaerbaum leer ist,
         * wird pTree nicht angehaengt. Andernfalls erhaelt der Binaerbaum den
         * uebergebenen AVLTree als rechten Teilbaum.
         *
         * @param pTree neuer linker Teilbaum vom Typ AVLTree<ContentType>
         */
        public void setRightTree(AVLTree<ContentType> pTree) {
            if (!this.isEmpty() && pTree != null) {
                this.node.right = pTree;
                updateHeight(node);
                node = rebalance(node);
            }
        }

        /**
         * Diese Anfrage liefert den linken Teilbaum des Binaerbaumes. Wenn der
         * Binaerbaum leer ist, wird null zurueckgegeben.
         *
         * @return linker Teilbaum vom Typ AVLTree<ContentType> oder null, wenn der
         *         aktuelle Binaerbaum leer ist
         */
        public AVLTree<ContentType> getLeftTree() {
            if (!this.isEmpty()) {
                return this.node.left;
            } else {
                return null;
            }
        }

        /**
         * Diese Anfrage liefert den rechten Teilbaum des Binaerbaumes. Wenn der
         * Binaerbaum (this) leer ist, wird null zurueckgegeben.
         *
         * @return rechter Teilbaum vom Typ AVLTree<ContentType> oder null, wenn der
         *         aktuelle Binaerbaum (this) leer ist
         */
        public AVLTree<ContentType> getRightTree() {
            if (!this.isEmpty()) {
                return this.node.right;
            } else {
                return null;
            }
        }

    }
