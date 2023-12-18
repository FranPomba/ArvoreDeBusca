
import java.text.NumberFormat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Francisco Pomba
 */
public class Cfuncionario {
    private int id;
    private String nome;
    private String sexo;
    private double salario;
    
    
    public Cfuncionario(){}
    public Cfuncionario(int id, String nome, String sexo, double salario){
        this.id=id;
        this.nome=nome;
        this.salario=salario;
        this.sexo=sexo;
    
    }

    /**
     * @return the identificacao
     */
    public int getId() {
        return id;
    }

    /**
     * @param identificacao the identificacao to set
     */
    public void setId(int identificacao) {
        this.id = identificacao;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public String getSalarioFormatado(){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(this.salario);
    
    }
}
