package DienstagsLinareSuche;

public class LineareSuche {
    Kunde[] MArray = new Kunde[5];
    Queue<Kunde> MQueue = new Queue<>();
    Stack<Kunde> MStack = new Stack<>();
    List<Kunde> MList = new List<>();

    public LineareSuche()
    {}

    public int CountArray()
    {
        int count = 0;
        for (Kunde k: MArray)
        {
            count++;
        }
        return count;
    }

    public int CountQueueMitNummernschild(String NRSchild)
    {
        Kunde first = MQueue.front();
        int count = 0;
        do {
            if (MQueue.front().getNummernschild().equals(NRSchild))
            {
                count++;
            }
            MQueue.enqueue(MQueue.front());
            MQueue.dequeue();
        }while(MQueue.front() != first);
        return count;
    }
    public String GibNummernschildVonKundeXAusStack(Kunde pKunde)
    {
        Stack<Kunde> Temp = MStack;
        while (!Temp.isEmpty())
        {
            if (Temp.top().isEqual(pKunde))
            {
                return pKunde.getNummernschild();
            }
            Temp.pop();
        }
        return "";
    }

    public List<Kunde> GibGroeßereNummernKunden(Kunde pKunde)
    {
        List<Kunde> TempL = new List<>();
        MList.toFirst();
        Kunde TempK = MList.getContent();

        do {
            if (pKunde.isLess(MList.getContent()))
            {
                TempL.insert(MList.getContent());
            }
            MList.append(MList.getContent());
            MList.remove();
        }while (MList.getContent() != TempK);
        return TempL;
    }
}