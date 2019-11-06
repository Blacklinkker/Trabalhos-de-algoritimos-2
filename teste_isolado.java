import javax.swing.JOptionPane;
import java.util.Arrays;
public class teste{
	public class NomesContasSaldos{
		String nomes;
		int contas;
		double saldos;
	}
	static NomesContasSaldos info[] = new NomesContasSaldos[9];

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
	}
	
	static int B[][]=new int[3][3];
	static{
		B[0][0] = 111;
		B[0][1] = 222;
		B[0][2] = 333;
		B[1][0] = 444;
		B[1][1] = 555;
		B[1][2] = 666;
		B[2][0] = 777;
		B[2][1] = 888;
		B[2][2] = 999;
	}
	
	static double C[][]=new double[3][3];
	static{
		C[0][0]=0.0;
		C[0][1]=0.0;
		C[0][2]=0.0;
		C[1][0]=0.0;
		C[1][1]=0.0;
		C[1][2]=0.0;
		C[2][0]=0.0;
		C[2][1]=0.0;
		C[2][2]=0.0;
	}
	public static void TodosNomesContasSaldos(){
	int a, i, j;
	new info();
	a = 0;
	info[0] = new NomesContasSaldos();
	for (i=0;i<3 ;i++ ) {
		for (j=0;j<3 ;j++ ) {
			info[a].nomes = A[i][j];
			info[a].contas = B[i][j];
			info[a].saldos = C[i][j];
			a++;
			}
		}
	}

	public static void main(String[] args) {
		int operacao = 0;
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
				case 3:
					TodosNomesContasSaldos();
					JOptionPane.showMessageDialog(null,"Números das contas " + info.contas
						+"\nNomes dos correntistas " + info.nomes
						+"\nSaldos das contas " + info.saldos);
					operacao = 0;
				break;
				case 6:
					operacao = 6;
				break;	
			}
		}
	}
}