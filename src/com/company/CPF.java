package cpf;
import javax.swing.JOptionPane;

public class CPF {
    private String entrada;
    private int digitos[] = new int[11];
    private int verificador_1;
    private int verificador_2;

    void lerCPF(){
        entrada = JOptionPane.showInputDialog("Insira os digitos do CPF");

        while(entrada.length() != 11 && entrada.length() != 9)
            entrada = JOptionPane.showInputDialog("Insira os digitos do CPF");

        lerDigitos(entrada);

        if(entrada.length() == 11){
            this.verificador_1 = Integer.parseInt(entrada.substring(9,10));
            this.verificador_2 = Integer.parseInt(entrada.substring(10,11));
        }
    }

    void lerDigitos(String entrada){
        int i;

        for(i=0;i<9;i++)
            digitos[i] = Integer.parseInt(entrada.substring(i,i+1));
    }

    void gerarPrimeiroDigito(){
        int i;

        this.verificador_1 = 0;

        for(i=0;i<9;i++){
            this.verificador_1 = this.verificador_1 + this.digitos[i]*(10-i);
        }

        if (this.verificador_1%11 == 0 || this.verificador_1%11 == 1)
            this.verificador_1 = 0;
        else
            this.verificador_1 = (11-(this.verificador_1%11));
    }

    void gerarSegundoDigito(){
        int i;
        this.verificador_2 = 0;

        for(i=0;i<9;i++){
            this.verificador_2 = this.verificador_2 + this.digitos[i]*(11-i);
        }

        this.verificador_2 = this.verificador_2 + this.verificador_1*2;

        if (this.verificador_2%11 == 0 || this.verificador_2%11 == 1)
            this.verificador_2 = 0;
        else
            this.verificador_2 = (11-(this.verificador_2%11));
    }

    void gerarCPF(){
        lerCPF();
        gerarPrimeiroDigito();
        gerarSegundoDigito();
    }

    void imprimirCPF(){
        System.out.println(this.entrada.substring(0, 9) + this.verificador_1 + this.verificador_2);
    }

    void verificarCPF(){
        int x, y;

        lerCPF();

        if(entrada.length() != 11)
            lerCPF();

        x = this.verificador_1;
        y = this.verificador_2;

        gerarPrimeiroDigito();
        gerarSegundoDigito();

        if((this.verificador_1 == x && this.verificador_2 == y))
            System.out.println("CPF valido!");
        else
            System.out.println("CPF invalido");
    }
}
