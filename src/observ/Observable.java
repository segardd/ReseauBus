package observ;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


class Observable
{

    public Observable() 
    {
        m_observateurs = new LinkedList<IObservateur>();
    }
    
    public void notifierObservateurs()
    {
       Iterator<IObservateur> it = m_observateurs.iterator();
        // Notifier tous les observers
       while(it.hasNext()){
           IObservateur obs = it.next();
           obs.notifier();
       }
    }
    
    void ajouterObservateur(IObservateur observateur)
    {
        // On ajoute un abonn� � la liste en le pla�ant en premier (impl�ment� en pull).
            // On pourrait placer cet observateur en dernier (impl�ment� en push, plus commun).
        m_observateurs.add(observateur);
    }
    
    void supprimerObservateur(IObservateur observateur)
    {
        // Enlever un abonn� a la liste
        m_observateurs.remove(observateur);
    }
    
    private List<IObservateur> m_observateurs;
}





