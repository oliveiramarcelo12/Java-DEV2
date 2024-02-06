package app;

import Controller.TarefasControl;
import View.JanelaPrincipal;

public class Main {
    public static void main(String[] args) {
        TarefasControl tarefasControl = new TarefasControl();  // Corrigido para TarefasControl
        JanelaPrincipal janelaPrincipal = new JanelaPrincipal(tarefasControl);  // Corrigido para TarefasControl
        janelaPrincipal.run();
    }
}
