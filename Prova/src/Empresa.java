
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Francisco Pomba
 */
public class Empresa {
    private Cnode raiz;
    public Empresa(){
        this.raiz = null;
    }
    public Cnode getRaiz(){
        return this.raiz;
    }
  
    public int qtdFuncionarios(Cnode raiz){
        if(raiz == null)
            return 0;
        else
            return 1 + qtdFuncionarios(raiz.getFilhoDireita())+ qtdFuncionarios(raiz.getFilhoEsquerda());
    }
    public boolean vazio(){
        return this.raiz == null;
    }
    public void inserirFuncionario(Cfuncionario funcionario) {
        raiz = inserir(raiz, funcionario);
    }
    private Cnode inserir(Cnode raiz, Cfuncionario funcionario) {
        if (raiz == null) {
            return new Cnode(funcionario);
        }

        if (funcionario.getId() < raiz.getFuncionario().getId()) {
            raiz.setFilhoEsquerda(inserir(raiz.getFilhoEsquerda(), funcionario));
        } else if (funcionario.getId() > raiz.getFuncionario().getId()) {
            raiz.setFilhoDireita(inserir(raiz.getFilhoDireita(), funcionario));
        }
        return raiz;
    }
    public boolean remover(int id){
         raiz = remover(raiz, id);
         return raiz != null;
    }
    private Cnode remover(Cnode raiz, int id) {
    if (raiz == null)
        return raiz;

    if (id < raiz.getFuncionario().getId()) {
        raiz.setFilhoEsquerda(remover(raiz.getFilhoEsquerda(), id));
    } else if (id > raiz.getFuncionario().getId()) {
        raiz.setFilhoDireita(remover(raiz.getFilhoDireita(), id));
    } else {
        if (raiz.getFilhoEsquerda() == null) {
            return raiz.getFilhoDireita();
        } else if (raiz.getFilhoDireita() == null) {
            return raiz.getFilhoEsquerda();
        }
            raiz.setFuncionario(encontrarSucessor(raiz.getFilhoDireita()));
            raiz.setFilhoDireita(remover(raiz.getFilhoDireita(), raiz.getFuncionario().getId()));
        }

        return raiz;
    }

    private Cfuncionario encontrarSucessor(Cnode raiz) {
        Cfuncionario sucessor = raiz.getFuncionario();
        while (raiz.getFilhoEsquerda() != null) {
            sucessor = raiz.getFilhoEsquerda().getFuncionario();
            raiz = raiz.getFilhoEsquerda();
        }
       return sucessor;
    }
    public Cfuncionario pesquisar(Cnode raiz, int id) {
        if (raiz == null || raiz.getFuncionario().getId() == id) {
            return (raiz != null) ? raiz.getFuncionario() : null;
        }

        if (id < raiz.getFuncionario().getId()) {
            return pesquisar(raiz.getFilhoEsquerda(), id);
        } else {
            return pesquisar(raiz.getFilhoDireita(), id);
        }
    }
    private void emPreOrdem(Cnode raiz, List<Cfuncionario> lista ){
        if(raiz != null){
            lista.add(raiz.getFuncionario());
            emPreOrdem(raiz.getFilhoEsquerda(), lista);
            emPreOrdem(raiz.getFilhoDireita(), lista);
        }  
    }
    private void emOrdem(Cnode raiz, List<Cfuncionario> lista){
        if(raiz != null){
            emOrdem(raiz.getFilhoEsquerda(), lista);
            lista.add(raiz.getFuncionario());
            emOrdem(raiz.getFilhoDireita(), lista);
        }
    
    }
    private void emPosOrdem(Cnode raiz, List<Cfuncionario> lista){
        if(raiz != null){
            emPosOrdem(raiz.getFilhoEsquerda(),lista);
            emPosOrdem(raiz.getFilhoDireita(),lista);
            lista.add(raiz.getFuncionario());
        
        }
    
    }   
    public List<Cfuncionario> funcionariosPreOrdem(){
        List<Cfuncionario> lista = new ArrayList<>();
        emPreOrdem(raiz, lista);
        return lista;
    }
    public List<Cfuncionario> funcionariosOrdem(){
        List<Cfuncionario> lista = new ArrayList<>();
        emOrdem(raiz, lista);
        return lista;
    }
    public List<Cfuncionario> funcionariosPosOrdem(){
        List<Cfuncionario> lista = new ArrayList<>();
        emPosOrdem(raiz, lista);
        return lista;
    }
    public int qtdChavesPares(){
        int qt = 0;
        for(Cfuncionario fun : funcionariosOrdem()){
            if(fun.getId()% 2==0)
                qt +=1;
        }
        return qt;
    }
    public int qtdChavesImpares(){
        int qt = 0;
        for(Cfuncionario fun : funcionariosOrdem()){
            if(fun.getId()% 2!=0)
                qt +=1;
        }
        return qt;
    }
    public double totalSalario(){
        double salario = 0.0;
        for(Cfuncionario func: funcionariosOrdem()){
            salario += func.getSalario();
        }
        return salario;
    }
     public String totalSalarioFormatado(){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(this.totalSalario());
    
    }
    public double salarioMedio(){
        int qtd = funcionariosOrdem().size();
        
        return totalSalario()/qtd;
    }
    public String salarioMedioFormatado(){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(this.salarioMedio());
    
    }
    public int qtdFuncSalAbaixoMed(){
        int qtd= 0;
        for(Cfuncionario func : funcionariosOrdem()){
            if(func.getSalario()<salarioMedio())
                qtd +=1;
        }
        return qtd;
    }
    public List<Cfuncionario> listaFuncSalAbaixoMed(){
        List<Cfuncionario> lista = new ArrayList<>();
        for(Cfuncionario func : funcionariosOrdem()){
            if(func.getSalario()<salarioMedio())
                lista.add(func);
        }
        return lista;
    }
    public int quantidadeFuncSexo(String sexo){
        int qtd = 0;
        for(Cfuncionario f : funcionariosOrdem()){
            if(f.getSexo().equals(sexo))
                qtd +=1;
        }
        return qtd;
    
    }
    public List<Cfuncionario> listarPorSexo(String sexo){
        List<Cfuncionario> lista = new ArrayList<>();
        for(Cfuncionario func : funcionariosOrdem()){
            if(func.getSexo().equals(sexo))
                lista.add(func);
        }
        return lista;
    }
    public Cfuncionario encontrarMaiorSalario() {
        List<Cfuncionario> lista = funcionariosOrdem();
        if (lista.isEmpty()) {
            return null; 
        }
        Cfuncionario maiorSalario = lista.get(0);
        for (int i = 1; i < lista.size(); i++) {
            Cfuncionario atual = lista.get(i);
            if (atual.getSalario() > maiorSalario.getSalario()) {
                maiorSalario = atual;
            }
        }
        return maiorSalario;
    }
    
}

