/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Francisco Pomba
 */
public class Cnode {
    private Cfuncionario funcionario;
    private Cnode filhoEsquerda, filhoDireita;
    
    public Cnode(Cfuncionario funcionario){
        this.funcionario = funcionario;
        this.filhoEsquerda = null;
        this.filhoDireita = null;
    }

    /**
     * @return the funcionario
     */
    public Cfuncionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Cfuncionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the filhoEsquerda
     */
    public Cnode getFilhoEsquerda() {
        return filhoEsquerda;
    }

    /**
     * @param filhoEsquerda the filhoEsquerda to set
     */
    public void setFilhoEsquerda(Cnode filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    /**
     * @return the filhoDireita
     */
    public Cnode getFilhoDireita() {
        return filhoDireita;
    }

    /**
     * @param filhoDireita the filhoDireita to set
     */
    public void setFilhoDireita(Cnode filhoDireita) {
        this.filhoDireita = filhoDireita;
    }
    
}
