import javax.swing.JOptionPane;
import java.util.*;
public class testetrab2{
	static String nome,rico,nomes,contas,saldos;
	static int i, j, a;
	static double saldo,maior;

	static double vetorsaldo[]=new double[9];

	static class NomesContasSaldos{ 
		int conta;
		double saldo;
	}

	static NomesContasSaldos info[][] = new NomesContasSaldos[3][3];

	public static final String A[][]=new String[3][3];
	static{
		
		A[0][0] = "Tibúrcio";
		A[0][1] = "Ricardo";
		A[0][2] = "João";
		A[1][0] = "Felisbino";
		A[1][1] = "Seu Zé";
		A[1][2] = "Dona Maria";
		A[2][0] = "Gedonstrôncio";
		A[2][1] = "Batman";
		A[2][2] = "Homem de Ferro";

		for (i=0;i<3 ;i++ ) {
			for (j=0;j<3 ;j++ ) {
				info[i][j]=new NomesContasSaldos();
			}
		}

		info[0][0].conta = 111;
		info[0][1].conta = 222;
		info[0][2].conta= 333;
		info[1][0].conta= 444;
		info[1][1].conta= 555;
		info[1][2].conta= 666;
		info[2][0].conta= 777;
		info[2][1].conta= 888;
		info[2][2].conta= 999;
	
		info[0][0].saldo=0.0;
		info[0][1].saldo=0.0;
		info[0][2].saldo=0.0;
		info[1][0].saldo=0.0;
		info[1][1].saldo=0.0;
		info[1][2].saldo=0.0;
		info[2][0].saldo=0.0;
		info[2][1].saldo=0.0;
		info[2][2].saldo=0.0;
	}
	
	
	//1 – Inserir Recebimento 
	public static double Recebimento(int conta,double transacao,double saldo2){
		for (i=0;i<3 ;i++ ) {
			for (j=0;j<3 ;j++ ) {
				if (conta == info[i][j].conta) {
					info[i][j].saldo = info[i][j].saldo + transacao;
					saldo2 =info[i][j].saldo;
					nome= A[i][j];
				}
			}
		}return saldo2;
	}

	//2 – Inserir Pagamento
	public static double Pagamento(int conta,double transacao,double saldo2){
		for (i=0; i<3; i++) {
			for (j=0; j<3; j++) {
				if (info[i][j].conta == conta) {
					info[i][j].saldo = info[i][j].saldo - transacao;
					saldo2 = info[i][j].saldo;
					nome = A[i][j];
				}
			}
		}return saldo2;
	}

	//3 – Mostre em apenas uma mensagem todos os Números de Conta, Correntistas e Saldos respectivos
	public static void TodosNomesContasSaldos(){
		nomes="";
		for (i=0;i<3 ;i++ ) {
			for (j=0;j<3 ;j++ ) {
				nomes =nomes + "|Nome do correntista: " +A[i][j]+"|  |Numero da conta: "+info[i][j].conta+"|  |Saldo da conta: "+info[i][j].saldo+"|"+"\n";
			}
		}
	}

	//4 – Mostre em apenas uma mensagem o Número da Conta, o Nome do Correntista e o saldo do correntista mais RICO.
	public static int Maisrico(){
		int contarico=0;
		maior=0;
		rico="";
		for (i=0;i<3 ;i++ ) {
			for (j=0;j<3;j++) {
				if (info[i][j].saldo>maior) {
					maior=info[i][j].saldo;
					rico=A[i][j];
					contarico=info[i][j].conta;
				}
			}
		}return contarico;
	}

	//5 – Mostre em apenas uma mensagem todos os saldos ordenados do menor para o maior usando BubbleSort.

	public static void OrdenadoMaisrico(){
		double aux;
		a = 0;
		for (i=0;i<3 ;i++ ) {
			for (j=0;j<3 ;j++ ) {
				vetorsaldo[a]=info[i][j].saldo;
				a++;
			}
		}
		int troca = 1;
		int fim = a - 1;
		while(troca==1){
			troca = 0;
			for(i=0; i<fim;i++){
				if (vetorsaldo[i] > vetorsaldo[i+1]){
					aux = vetorsaldo[i];
					vetorsaldo[i] = vetorsaldo[i+1];
					vetorsaldo[i+1] = aux;
					troca = 1;
				}	
			}
		}                    
	}

	public static void main(String[] args) {
		int operacao = 0;
		double saldo2=0;
		
		while(operacao<=5){
			switch(operacao){
				case 0:
					operacao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das operações abaixo: \n"
						+"1 - Inserir Recebimento \n"
						+"2 - Inserir Pagamento \n"
						+"3 - Todos os Números de Conta, Correntistas e Saldos respectivos \n"
						+"4 - O Número da Conta, o Nome do Correntista e o saldo do correntista mais RICO \n"
						+"5 - Os saldos ordenados do menor para o maior \n"
						+"6 - Sair"));
				break;
 
				case 1:
					int contaAReceber = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da conta"));
					double recebimento = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor a ser depositado"));
					saldo=Recebimento(contaAReceber,recebimento,saldo2);
					JOptionPane.showMessageDialog(null,nome + " seu saldo atual é de: " + saldo);
					operacao = 0;
				break;
			
				case 2:
					int contaAPagar = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta"));
					double pagamento = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do pagamento"));
					saldo=Pagamento(contaAPagar,pagamento,saldo2);
					JOptionPane.showMessageDialog(null, nome + " seu saldo atual é de: " + saldo);
					operacao = 0;
				break;
				
				case 3:
					TodosNomesContasSaldos();
					JOptionPane.showMessageDialog(null,nomes);
					operacao = 0;
				break;

				case 4:
					int maisrico = Maisrico();
					JOptionPane.showMessageDialog(null," Numero da conta do correntista mais rico: "+maisrico
						+"\n Em nome de: "+rico
						+"\n Com o saldo de: "+maior);
					operacao = 0;
				break;

				case 5:                   
					OrdenadoMaisrico();
					JOptionPane.showMessageDialog(null,"Os saldos ordenados do menor para o maior são: \n"+ Arrays.toString(vetorsaldo));
					operacao = 0;
				break;

				case 6:
					operacao = 6;
				break;
			}
		}
	}
}
