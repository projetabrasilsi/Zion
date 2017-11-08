package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;

import antlr.StringUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.entities.Pessoa;
import model.enums.Enum_Aux_Meses_Anos;
import model.enums.Enum_Aux_Sim_ou_Nao;
import model.outros.Perfil_Pessoa_Logada;
import viacep.CEP;

@SuppressWarnings("serial")
public class Utilidades implements Serializable {
	private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final String caminhoFotoBrinde = System.getProperty("user.home") + "/imagens/brindes/";
	private static final String caminhoFotoPessoas = System.getProperty("user.home") + "/imagens/pessoas/";
	private static final String caminhoFotoObjetos = System.getProperty("user.home") + "/imagens/objetos/";
	private static final String caminhoAudioObjetos = System.getProperty("user.home") + "/audios/objetos/";
	private static final String caminhoIptu = System.getProperty("user.home") + "/xls/iptu/";
	private static final String caminhoIptuDownload = System.getProperty("user.home") + "/Desktop/xls/iptu/";
	private static String caminhoPastasEmpresas = System.getProperty("user.home") + "/pastasEmpresas/";
	private static String caminhoJsonLoginEmpresaUsuarios = System.getProperty("user.home") + "/Login/";
	private static Perfil_Pessoa_Logada pPL;
	private static String textoLabel;
	private static boolean ok;
	private static boolean finalizado = false;
	private static String textodeRetorno = "";  

	

	

	public static String getTextodeRetorno() {
		return textodeRetorno;
	}

	public static void setTextodeRetorno(String textodeRetorno) {
		Utilidades.textodeRetorno = textodeRetorno;
	}

	public static boolean isOk() {
		return ok;
	}

	public static void setOk(boolean ok) {
		Utilidades.ok = ok;
	}

	public static String getTextoLabel() {
		return textoLabel;
	}

	public static void setTextoLabel(String textoLabel) {
		Utilidades.textoLabel = textoLabel;
	}

	@SuppressWarnings("unused")
	public static List<String> retornaListaExcell() {
		List<String> array = new ArrayList<>();

		String fileName = "C:\\Users\\PAULO\\Desktop\\Teste com Threads.xls";

		try {
			FileInputStream arquivo = new FileInputStream(new File(fileName));

			HSSFWorkbook workbook;
			try {
				workbook = new HSSFWorkbook(arquivo);

				HSSFSheet sheetAlunos = workbook.getSheetAt(0);

				Iterator<Row> rowIterator = sheetAlunos.iterator();

				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();

					String t = "" + (int) row.getCell(0).getNumericCellValue();

					array.add(t);

				}
				try {
					arquivo.close();
				} catch (IOException e) {

					e.printStackTrace();
				}

			} catch (IOException e1) {

				e1.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		return array;
	}

	public static void addTextLimiter(final PasswordField pSF, final int maxLength) {
		pSF.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (pSF.getText().length() > maxLength) {
					String s = pSF.getText().substring(0, maxLength);
					pSF.setText(s);
				}
			}
		});
	}

	public static boolean IsInteiroValido(String inteiro) {
		inteiro = "" + inteiro.trim();
		if (inteiro == null || inteiro == "" || inteiro.contains("^[a-Z]") || inteiro.isEmpty())
			return false;
		else
			return true;

	}

	public static List<String> retornaListaExcellParcial(int inicio, int fim, List<String> lista) {
		List<String> array = new ArrayList<>();
		if (fim > lista.size())
			fim = lista.size();

		array = lista.subList(inicio, fim);

		return array;

	}

	public static String RetornaMesAnoExtenso() {
		int ano;
		int mes;
		Calendar.getInstance();
		ano = Calendar.YEAR;
		mes = Calendar.MONTH;
		String mesAno = Enum_Aux_Meses_Anos.pegaAnoPeloCodigo(mes).getDescricao() + ano;
		return mesAno;

	}

	public static String RetornaMesAnoExtenso(int ano, int mes) {
		String mesAno = Enum_Aux_Meses_Anos.pegaAnoPeloCodigo(mes).getDescricao() + ano;
		return mesAno;

	}

	public static void criarPasta(String caminho) {

		File diretorio = new File(caminho); // ajfilho é uma pasta!
		if (!diretorio.exists())
			diretorio.mkdirs(); // mkdir() cria somente um diretório, mkdirs() cria diretórios e subdiretórios.

	}

	public static boolean compactarArquivos(String caminhoOrigem, String caminhodestinoZip, String nomeZip,
			List<String> arquivos) {

		try {

			String zipFileName = caminhodestinoZip + nomeZip;
			Utilidades.apagarArquivo(zipFileName);

			FileOutputStream fos = new FileOutputStream(zipFileName);
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (String aFile : arquivos) {
				aFile = caminhoPDF + aFile;
				zos.putNextEntry(new ZipEntry(new File(aFile).getName()));

				byte[] bytes = Files.readAllBytes(Paths.get(aFile));
				zos.write(bytes, 0, bytes.length);
				zos.closeEntry();
			}

			zos.close();

		} catch (FileNotFoundException ex) {
			System.err.println("A file does not exist: " + ex);
		} catch (IOException ex) {
			System.err.println("I/O error: " + ex);
		}

		return true;
	}

	public static String getCaminhoiptudownload() {
		return caminhoIptuDownload;
	}

	public static String getCaminhoiptu() {
		return caminhoIptu;
	}

	private static final String caminhoFotoVouchers = System.getProperty("user.home") + "/imagens/vouchers/";
	private static final String caminhoFotoAgendamento = System.getProperty("user.home") + "/imagens/agendamento/";
	private static String caminhoFotoComprovante = System.getProperty("user.home") + "/imagens/comprovantes/";
	private static final String caminhoPDF = System.getProperty("user.home") + "/pdfs/";

	private static String tipoImagem = ".jpeg";
	private static String tipoImagemSemPonto = "jpeg";
	private static String tipoAudio = ".mp3";
	private static String tipoAudioSemPonto = "mp3";
	private static final String caminhobase = System.getProperty("user.home") + "/imagens/";
	private static String caminhobase2 = System.getProperty("user.home") + "\\imagens\\";
	private static final String caminhobaseaudio = System.getProperty("user.home") + "/audios/";
	private static String caminhobaseaudio2 = System.getProperty("user.home") + "\\audios\\";
	private static final String branco = Utilidades.getCaminhobase() + "branco" + Utilidades.getTipoImagem();
	private static final String branco2 = Utilidades.getCaminhobase2() + "branco" + Utilidades.getTipoImagem();
	private static final String brancoaudio = Utilidades.getCaminhobaseaudio() + "branco" + Utilidades.getTipoImagem();
	private static final String brancoaudio2 = Utilidades.getCaminhobaseaudio2() + "branco"
			+ Utilidades.getTipoImagem();
	private static final String naoatingido = "/images/" + "naoatingido" + Utilidades.getTipoImagem();
	private static final String atingido = "/images/" + "atingido" + Utilidades.getTipoImagem();
	@SuppressWarnings("unused")
	private static final float umaTememCm = 2.54f;

	public static boolean arquivoExiste(String arquivo) {

		File file = new File(arquivo);

		if (file.exists())
			return true;
		else
			return false;
	}

	public static void apagarArquivo(String arquivo) {
		if (arquivoExiste(arquivo)) {
			File f = new File(arquivo);
			f.delete();

		}
	}

	public static String retornaCaminho(String diretorio, boolean temporario) {
		String retorno = "";
		if (!temporario) {
			/*
			 * *.* - coloquei porque se não fica apenas o nome do diretorio atual e pega o
			 * diretório absoluto anterior
			 */
			criaDiretorio(diretorio + "*.*");
		} else {
			retorno = System.getProperty("java.io.tmpdir");
		}

		return retorno;

	}

	public static String encodeImage(byte[] imageByteArray) {
		return Base64.encodeBase64URLSafeString(imageByteArray);
	}

	/**
	 * Decodes the base64 string into byte array
	 *
	 * @param imageDataString
	 *            - a {@link java.lang.String}
	 * @return byte array
	 */
	public static byte[] decodeImage(String imageDataString) {
		return Base64.decodeBase64(imageDataString);
	}

	public static void converterTextoemImagem(String imageDataString, String caminho) {
		byte[] imageByteArray = decodeImage(imageDataString);

		// Write a image byte array into file system
		try {
			FileOutputStream imageOutFile = new FileOutputStream(caminho);
			imageOutFile.write(imageByteArray);
			imageOutFile.close();

		} catch (FileNotFoundException e) {

		} catch (IOException ioe) {

		}

	}

	public static boolean salvarImagemTemporaria(byte[] imageByteArray) {
		InputStream is = new ByteArrayInputStream(imageByteArray);
		Path arquivoTemp;
		try {
			arquivoTemp = Files.createTempFile(null, null);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		try {
			Files.copy(is, arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static String converterImagememTexto(String caminho) {

		File file = new File(caminho);

		// Write a image byte array into file system
		String imageDataString = null;
		try {
			// Reading a Image file from file system
			FileInputStream imageInFile = new FileInputStream(file);
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			imageDataString = encodeImage(imageData);
			imageInFile.close();
		} catch (FileNotFoundException e) {

		} catch (IOException ioe) {

		}
		return imageDataString;

	}

	public static Date transformaStringEmData(String data, boolean hora) throws ParseException {

		if (data == null || data.equals(""))
			return null;
		Date date = null;
		DateFormat formatter = null;
		try {
			if (hora)
				formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

			else
				formatter = new SimpleDateFormat("dd/MM/yyyy");

			date = (java.util.Date) formatter.parse(data);
		} catch (ParseException e) {
			throw e;
		}
		return date;
	}

	public static String transformaDataEmString(Calendar data, boolean hora) throws ParseException {
		if (data == null)
			return "";
		DateFormat formatter = null;
		String retorno = "";
		if (hora)
			formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		else
			formatter = new SimpleDateFormat("dd/MM/yyyy");

		retorno = formatter.format(data.getTime());
		return retorno;
	}

	public static String transformaDataEmString(Date data, boolean hora) throws ParseException {
		if (data == null)
			return "";
		DateFormat formatter = null;
		if (hora)
			formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		else
			formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(data);
	}

	public static final LocalDate transformaDataEmFormatoLocal(Date data) {
		String date = new SimpleDateFormat("dd/MM/yyyy").format(data);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate;
	}

	public static final Date transformaFormatoLocalEmData(LocalDate data) {
		java.util.Date date = java.sql.Date.valueOf(data);
		return date;
	}

	public static void criaDiretorio(String caminho) {
		File file = new File(caminho);
		String parentPath = file.getAbsoluteFile().getParent();
		Path newDirectoryPath = Paths.get(parentPath);

		if (!Files.exists(newDirectoryPath)) {

			try {

				Files.createDirectory(newDirectoryPath);

			} catch (IOException e) {
				System.err.println(e);
			}
		}

	}

	public static String getCaminhofotopessoas() {
		return caminhoFotoPessoas;
	}

	public static String getCaminhofotoobjetos() {
		return caminhoFotoObjetos;
	}

	public static String tipodeImagem() {
		return getTipoimagem();
	}

	public static Calendar retornaCalendario() {

		TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo");
		TimeZone.setDefault(tz);
		Calendar c = Calendar.getInstance(tz);
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
		String sData = sd.format(c.getTime());

		try {
			c.setTime(sd.parse(sData));
			// c.clear(Calendar.ZONE_OFFSET);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return c;

	}

	public static String retornaDataDoDiaString() {
		TimeZone tz = TimeZone.getDefault();
		Calendar c = Calendar.getInstance(tz);
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		String sData = sd.format(c.getTime());

		return sData;

	}

	public static Date retornaCalendario2() {
		TimeZone tz = TimeZone.getDefault();
		Calendar c = Calendar.getInstance(tz);
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		String sData = sd.format(c.getTime());

		try {
			c.setTime(sd.parse(sData));
			c.clear(Calendar.ZONE_OFFSET);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date data = new Date();
		data = c.getTime();
		return data;

	}

	public static Calendar retornaData() {
		Calendar c = Calendar.getInstance();
		return c;
	}

	public static Date retornaValidade(int diasValidade) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, +diasValidade);

		return c.getTime();
	}

	public static Date retornaHora(String hora) {
		Date d = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

			d = sdf.parse(hora);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	public static String retiraCaracteres(String texto) {
		if (texto == null)
			texto = "";
		texto = texto.replaceAll("[^\\p{ASCII}]", "").replaceAll("[.-]", "").replaceAll("\\/", "").replaceAll("\\(", "")
				.replaceAll("\\)", "").replaceAll(" ", "");
		texto = texto.replaceAll("_", "");
		return texto;
	}

	public static String retiraVazios(String texto) {
		if (texto == null)
			texto = "";
		texto.trim();
		return texto;
	}

	public static boolean estaVazio(String texto) {
		texto = StringUtils.stripBack(texto, " \t");
		texto = StringUtils.stripFront(texto, " \t");
		return texto.length() <= 0;
	}

	public static String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public static String formataString(String str) {

		return removerAcentos(str);

	}

	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	public static boolean isValidCPF(String cpf) {
		if ((cpf == null) || (cpf.length() != 11))
			return false;

		Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
		Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
		boolean retorno = cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
		return retorno;
	}

	public static boolean isValidCNPJ(String cnpj) {
		if ((cnpj == null) || (cnpj.length() != 14))
			return false;

		Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
		Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
		return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
	}

	public static String retornaSomenteNumeros(String texto) {
		if (texto != null) {

			return texto.replaceAll("[^0123456789]", "");

		} else {

			return "";

		}

	}

	public static boolean isEmailValid(String email) {
		if ((email == null) || (email.trim().length() == 0))
			return false;

		String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
		Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static List<Enum_Aux_Sim_ou_Nao> listaSN() {
		List<Enum_Aux_Sim_ou_Nao> lista = new ArrayList<Enum_Aux_Sim_ou_Nao>();
		Enum_Aux_Sim_ou_Nao[] lSN;
		lSN = Enum_Aux_Sim_ou_Nao.values();

		for (Enum_Aux_Sim_ou_Nao l : lSN) {
			lista.add(l);
		}
		return lista;
	}

	public static CEP buscarCep(String cep) {
		String json;
		try {
			URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuilder jsonSb = new StringBuilder();
			br.lines().forEach(l -> jsonSb.append(l.trim()));

			json = jsonSb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		CEP cp = new CEP();
		if (isJSONValid(json)) {
			cp = readJson(json);
			if (cp == null)
				cp = new CEP();
			return cp;
		} else {
			cp = null;
			enviaAlertError("JSON", "Formato", "Formato é Inválido");

		}
		return cp;

	}

	public static boolean isJSONValid(String jsonInString) {
		final Gson gson = new Gson();

		try {
			gson.fromJson(jsonInString, Object.class);
			return true;
		} catch (com.google.gson.JsonSyntaxException ex) {
			return false;
		}
	}

	@SuppressWarnings({ "unused" })
	public static CEP readJson(String file) {
		JSONParser parser = new JSONParser();
		CEP cep = new CEP();
		try {

			Gson g = new Gson();
			cep = g.fromJson(file, CEP.class);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return cep;
	}

	public static void enviaAlertError(String titulo, String cabecalho, String contexto) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(titulo);
		alert.setHeaderText(cabecalho);
		alert.setContentText(contexto);
		alert.showAndWait();
	}

	public static String getCaminhofotobrinde() {
		return caminhoFotoBrinde;
	}

	public static String getCaminhofotovouchers() {
		return caminhoFotoVouchers;
	}

	public static String getTipoimagem() {
		return tipoImagem;
	}

	public static String caminho(String tipo) {
		String caminho;
		if (tipo.toUpperCase().equals("BRINDES"))
			caminho = System.getProperty("user.dir") + getCaminhofotobrinde();
		else
			caminho = getCaminhofotovouchers();
		return caminho;
	}

	public static String getCaminhobase() {
		return caminhobase;
	}

	public static void setTipoimagem(String tipoimagem) {
		tipoImagem = tipoimagem;
	}

	public static String randon(String param) {

		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
		Random random = new Random();
		String armazenaChaves = "";
		Long valor;
		String novoValor;
		int index = -1;
		for (int i = 0; i < 4; i++) {
			index = random.nextInt(letras.length());
			armazenaChaves += letras.substring(index, index + 1);
			valor = 0l;
			novoValor = "" + valor;
			while (novoValor.length() <= 1) {
				valor = random.nextInt(10) * Long.valueOf(param);
				novoValor = "" + valor;
			}

			armazenaChaves += novoValor.substring(1, 2);
			if (i % 2 == 0)
				armazenaChaves += "-";
		}

		String invertida = new StringBuilder(armazenaChaves).reverse().toString();
		return invertida;
	}

	public static String formataNomeDaRegiao(String nome) {
		String[] nomeSplit = nome.split(" ");
		nome = "";
		for (int i = 0; i < nomeSplit.length; i++) {
			nomeSplit[i] = nomeSplit[i].toUpperCase();
			if (!nomeSplit[i].equals("DA") && !nomeSplit[i].equals("DO") && !nomeSplit[i].equals("DE")) {
				nomeSplit[i] = removerAcentos(nomeSplit[i].substring(0, 1).toUpperCase()
						+ nomeSplit[i].substring(1, nomeSplit[i].length()).toLowerCase());
			} else {
				nomeSplit[i] = removerAcentos(nomeSplit[i].toLowerCase());
			}
			nome = nome + nomeSplit[i] + " ";
		}
		return nome;
	}

	public static Pessoa criapessoa(String mensagem) {
		Pessoa pessoa = new Pessoa();

		return pessoa;
	}

	public static String getDataPorExtenso(Date data) {
		DateFormat dfmt = new SimpleDateFormat("d 'de' MMMM 'de' yyyy");
		return dfmt.format(data);
	}

	public static void copiaOrigemDestino(String origem, String destino) {
		Path or = Paths.get(origem);
		Path de = Paths.get(destino);
		try {
			Files.copy(or, de, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException error) {
			error.printStackTrace();
		}
	}

	public static void WriteFileJson(String json, String nomeArquivo) {
		criaDiretorio(caminhoJsonLoginEmpresaUsuarios);
		Path arquivo = Paths.get(caminhoJsonLoginEmpresaUsuarios + nomeArquivo);
		/*
		 * Log_Login_Empresas lLEmpresas,Log_Login_Usuario lLUsuarios, String
		 * nomeArquivo
		 */

		/*
		 * { “titulo”: “JSON x XML”, “resumo”: “o duelo de dois modelos de representação
		 * de informações”, “ano”: 2012, “genero”: [“aventura”, “ação”, “ficção”] }
		 */

		if (!Files.exists(arquivo)) {
			BufferedWriter bw = null;
			try {
				Files.createFile(arquivo);
				bw = new BufferedWriter(new FileWriter(arquivo.toFile(), true));
				bw.write(json);
			} catch (IOException ex) {
				Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				try {
					bw.close();
				} catch (IOException ex) {
					Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		} else {
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(arquivo.toFile(), true));
				bw.newLine();
				bw.write(json);
			} catch (IOException ex) {
				Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				try {
					bw.close();
				} catch (IOException ex) {
					Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public static List<String> ReadFileJson(String nomeArquivo) {
		Path arquivo = Paths.get(caminhoJsonLoginEmpresaUsuarios + nomeArquivo);

		List<String> linhas = new ArrayList<>();

		if (Files.exists(arquivo)) {
			try {
				linhas = Files.readAllLines(arquivo, Charset.defaultCharset());
			} catch (IOException ex) {
				Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return linhas;
	}

	public static Node trocaTabPorEnter(Node no) {
		no.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
			if (event.getCode() == KeyCode.ENTER) {
				KeyEvent newEvent = new KeyEvent(null, null, KeyEvent.KEY_PRESSED, "", "\t", KeyCode.TAB,
						event.isShiftDown(), event.isControlDown(), event.isAltDown(), event.isMetaDown());

				Event.fireEvent(event.getTarget(), newEvent);
				event.consume();
			}
		});
		return no;
	}

	public Object instanciar_Classe(String classe) {
		Object obj = null;
		try {
			obj = Class.forName(classe).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {

			e.printStackTrace();
		}
		return obj;
	}

	public static String calculadiferencaTempo(Calendar tempoInicial, Calendar tempoFinal) {
		String texto = "";
		try {

			long ini = tempoInicial.getTimeInMillis();
			if (tempoFinal == null)
				tempoFinal = Calendar.getInstance();
			long fim = tempoFinal.getTimeInMillis();
			long dif = fim - ini;
			DateFormat sdf = DateFormat.getTimeInstance(DateFormat.MEDIUM);
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			// SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			String sTIni = transformaDataEmString(tempoInicial, true);
			String sTFim = transformaDataEmString(tempoFinal, true);

			texto = "Início : " + sTIni + "    Fim :  " + sTFim + "    Tempo de Execução => " + sdf.format(dif);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return texto;
	}

	

	public static String getCaminhopdf() {
		return caminhoPDF;
	}

	public static String getTipoImagem() {
		return tipoImagem;
	}

	public static String getTipoAudio() {
		return tipoAudio;
	}

	public static String getCaminhofotoagendamento() {
		return caminhoFotoAgendamento;
	}

	public static String getBranco() {
		return branco;
	}

	public static String getNaoatingido() {
		return naoatingido;
	}

	public static String getAtingido() {
		return atingido;
	}

	public static String getTipoImagemSemPonto() {
		return tipoImagemSemPonto;
	}

	public static String getTipoAudioSemPonto() {
		return tipoAudioSemPonto;
	}

	public static String getCaminhofotocomprovante() {
		return caminhoFotoComprovante;
	}

	public static void setCaminhofotocomprovante(String caminhofotocomprovante) {
		caminhoFotoComprovante = caminhofotocomprovante;
	}

	public static String getBranco2() {
		return branco2;
	}

	public static String getCaminhobase2() {
		return caminhobase2;
	}

	public static void setCaminhobase2(String caminhobase2) {
		Utilidades.caminhobase2 = caminhobase2;
	}

	public static String getCaminhoaudioobjetos() {
		return caminhoAudioObjetos;
	}

	public static String getBrancoaudio() {
		return brancoaudio;
	}

	public static String getBrancoaudio2() {
		return brancoaudio2;
	}

	public static String getCaminhobaseaudio2() {
		return caminhobaseaudio2;
	}

	public static void setCaminhobaseaudio2(String caminhobaseaudio2) {
		Utilidades.caminhobaseaudio2 = caminhobaseaudio2;
	}

	public static String getCaminhobaseaudio() {
		return caminhobaseaudio;
	}

	public static String getCaminhopastasempresas() {
		return caminhoPastasEmpresas;
	}

	public static void setCaminhopastasempresas(String caminhopastasempresas) {
		caminhoPastasEmpresas = caminhopastasempresas;
	}

	public static Perfil_Pessoa_Logada getpPL() {
		return pPL;
	}

	public static void setpPL(Perfil_Pessoa_Logada pPL1) {
		pPL = pPL1;
	}

	public static boolean isFinalizado() {
		return finalizado;
	}

	public static void setFinalizado(boolean finalizado) {
		Utilidades.finalizado = finalizado;
	}

}
