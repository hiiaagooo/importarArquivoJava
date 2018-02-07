package br.com.correios.realize.util;

import br.com.correios.realize.model.enums.TipoArquivoEnum;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ArquivoUtils {

	public static final String UTF_8 = "UTF-8";
	public static final String ISO_8859_1 = "ISO-8859-1" ;
	public static String DIRETORIO_TEMPORARIO = System.getProperty("java.io.tmpdir");

	private static final Logger log = LoggerFactory.getLogger(ArquivoUtils.class);

	/**
     * <p>
	 * Salva um arquivo em um diretÃ³rio atravÃ©s dos seus bytes.
	 * </p>
	 * 
	 * salvarArquivo(bytesArquivo,"D:\\tmp\\arquivos\\","arquivo.pdf")
	 * 
	 * @param bytesArquivo
	 *            array de bytes do arquivo a ser salvo
	 * @param caminhoDiretorio
	 *            caminho do diretÃ³rio a ser salvo o arquivo Ex.: "D:\\tmp\\arquivos\\"
	 * @param nomeArquivo
	 *            nome do arquivo a ser salvo(com sua extensÃ£o)
	 */
	public static void salvarArquivo(byte[] bytesArquivo, String caminhoDiretorio, String nomeArquivo) throws RuntimeException, IOException {
		InputStream inputStreamArquivo = null;
		if (bytesArquivo == null || (StringUtils.isEmpty(caminhoDiretorio) && StringUtils.isEmpty(nomeArquivo))) {
			throw new RuntimeException("Preencha os parametros necessários");
		}
		try {
			inputStreamArquivo = new ByteArrayInputStream(bytesArquivo);
			salvarArquivo(inputStreamArquivo, caminhoDiretorio, nomeArquivo);
		}finally {
			inputStreamArquivo.close();
		}
	}

	/**
	 * <p>
	 * Salva um arquivo em um diretÃ³rio atravÃ©s do seu InputStream
	 * </p>
	 * 
	 * salvarArquivo(inputStream,"D:\\tmp\\arquivos\\","arquivo.pdf")
	 *
	 * @param caminhoDiretorio
	 *            caminho do diretÃ³rio a ser salvo o arquivo Ex.: "D:\\tmp\\arquivos\\"
	 * @param nomeArquivo
	 *            nome do arquivo a ser salvo(com sua extensÃ£o)
	 */
	public static void salvarArquivo(InputStream inputStreamArquivo, String caminhoDiretorio, String nomeArquivo) throws RuntimeException {
		if (inputStreamArquivo != null && !StringUtils.isEmpty(caminhoDiretorio) && !StringUtils.isEmpty(nomeArquivo)) {

			try {
				criarDiretorio(caminhoDiretorio);

				File file = new File(caminhoDiretorio + File.separatorChar + nomeArquivo);
				BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStreamArquivo);
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				try {
					byte[] buffer = new byte[1024];
					int count;
					while ((count = bufferedInputStream.read(buffer)) > 0)
						fileOutputStream.write(buffer, 0, count);
				} finally {
					bufferedInputStream.close();
					fileOutputStream.close();
				}
			} catch (IOException exception) {
				log.error("Erro de E/S",exception);
			} catch (Exception e) {
				log.error("Erro desconhecido",e);
			}
		} else {
			throw new RuntimeException("Existem parâmetros não preechidos");
		}
	}

	/**
	 * <p>
	 * Recupera um arquivo salvo em um diretÃ³rio e retorna seu InputStream
	 * </p>
	 * 
	 * recuperarArquivoDeDiretorio("D:\\tmp\\arquivos\\","arquivo.pdf")
	 * 
	 * @param caminhoDiretorio
	 *            caminho do diretÃ³rio aonde o arquivo se encontra
	 * @param nomeArquivo
	 *            nome do arquivo a ser recuperado(com sua extensÃ£o)
	 * @return inputstream
	 */
	public static InputStream recuperarArquivoDeDiretorio(String caminhoDiretorio, String nomeArquivo) throws IOException, RuntimeException {
		return recuperarArquivoDeDiretorio(caminhoDiretorio + File.separatorChar + nomeArquivo);
	}

	/**
	 * <p>
	 * Recupera um arquivo salvo em um diretÃ³rio e retorna seu InputStream
	 * </p>
	 * 
	 * recuperarArquivoDeDiretorio("D:\\tmp\\arquivos\\arquivo.pdf")
	 * 
	 * @param caminhoDiretorioCompleto
	 *            caminho completo do diretÃ³rio+nomeArquivo
	 * @return InputStream
	 */
	public static InputStream recuperarArquivoDeDiretorio(String caminhoDiretorioCompleto) throws IOException, RuntimeException {
		if (StringUtils.isEmpty(caminhoDiretorioCompleto)) {
			throw new RuntimeException("Existem parâmetros não preechidos");
		}

		File f = new File(caminhoDiretorioCompleto);
		InputStream stream = new FileInputStream(f);
		return stream;
	}

	/**
	 * <p>
	 * Exclui um arquivo salvo em um diretÃ³rio(se o arquivo estiver sendo usado(aberto), nÃ£o hÃ¡ garantia de exclusÃ£o)
	 * </p>
	 * 
	 * excluirArquivo("D:\\tmp\\arquivos\\","arquivo.pdf")
	 * 
	 * @param caminhoDiretorio
	 *            caminho do diretÃ³rio aonde o arquivo se encontra
	 * @param nomeArquivo
	 *            nome do arquivo a ser recuperado(com sua extensÃ£o)
	 */
	public static void excluirArquivo(String caminhoDiretorio, String nomeArquivo) {
		excluirArquivo(caminhoDiretorio + File.separatorChar + nomeArquivo);
	}

	/**
	 * <p>
	 * Exclui um arquivo salvo em um diretÃ³rio(se o arquivo estiver sendo usado(aberto), nÃ£o hÃ¡ garantia de exclusÃ£o)
	 * </p>
	 * 
	 * excluirArquivo("D:\\tmp\\arquivos\\arquivo.pdf")
	 * 
	 * @param caminhoDiretorioCompletoArquivo
	 *            caminho completo do diretÃ³rio+nomeArquivo
	 */
	public static void excluirArquivo(String caminhoDiretorioCompletoArquivo) {
		File file = new File(caminhoDiretorioCompletoArquivo);
		if (file.exists())
			file.delete();
	}

	/**
	 * <p>
	 * Cria um diretÃ³rio passado por uma String
	 * </p>
	 * 
	 * criarDiretorio("D:\\tmp\\arquivos\\")
	 * 
	 * @param caminhoDiretorio
	 *            caminho completo do diretÃ³rio
	 */
	public static void criarDiretorio(String caminhoDiretorio) throws Exception {
		File file = new File(caminhoDiretorio);
		if (!file.isDirectory()) {
			file.mkdirs();
		}

	}
	
	public static byte[] converterInputStreamToByteArray(InputStream is) throws IOException {
		byte[] bytes =  IOUtils.toByteArray(is);
		return bytes;
	}
	
	public static byte[] converterOutputStreamToByteArray(OutputStream os) throws IOException {
		ByteArrayOutputStream bos = (ByteArrayOutputStream)os;
		return bos.toByteArray();
	}
	
	public static boolean verificarPreenchimentoInputStream(InputStream is) throws IOException {
		byte b[] = new byte[1];
		is.read(b, 0 , 1);
		return b[0] != -1 && b[0] != 0 ;
	}
	
	
	@SuppressWarnings("restriction")
	public static String converterByteArrayToBase64(byte[] byteArray){
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		return encoder.encode(byteArray);
	}
	
	public static TipoArquivoEnum recuperarTipoArquivoPorMimeType(String stringMimeType){
		stringMimeType = recuperarStringMimeTypeCorreto(stringMimeType);
		return TipoArquivoEnum.recuperarPorMimeType(stringMimeType);
	}
	
	public static String recuperarStringMimeTypeCorreto(String stringMimeType){
		if(stringMimeType == null) return null;
		
		//Verifica todas as descriÃ§Ãµes parecidas com o MimeType de PDF
		stringMimeType = ("application/pkcs7-mime".equals(stringMimeType)
				|| "application/pkcs7".equals(stringMimeType)) ? "application/pdf"
						: stringMimeType;
		stringMimeType = "pdf".equalsIgnoreCase(stringMimeType) ? "application/pdf"
				: stringMimeType;
		
		//Verifica todas as descriÃ§Ãµes parecidas com o MimeType de HTML
		stringMimeType = (stringMimeType.contains("html") ? "text/html": stringMimeType.equalsIgnoreCase("html") ? "text/html": stringMimeType);
		
		return stringMimeType;
		
	}
	
	public static boolean verificarPreenchimentoByteArray(byte[] arquivo) {
		return arquivo != null && arquivo.length > 0;
	}

	public static InputStream converterByteArrayToInputStream(byte[] arquivo) {
		ByteArrayInputStream bis = new ByteArrayInputStream(arquivo);
		return bis;
	}
	
	public static byte[] converterArrayBytesParaZipBytes(String filename, byte[] input) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(baos);
		ZipEntry entry = new ZipEntry(filename);
		entry.setSize(input.length);
		zos.putNextEntry(entry);
		zos.write(input);
		zos.closeEntry();
		zos.close();
		return baos.toByteArray();
	}

	public static byte[] converterInputStreamParaZipBytes(String filename, InputStream is) throws IOException {
		
		byte[] arquivo = null;
        	
    	final int BUFFER = 2048;
        byte buffer[] = new byte[BUFFER];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(out);
        zos.putNextEntry(new ZipEntry(filename));
        int length;
        while ((length = is.read(buffer)) > 0) {
            zos.write(buffer, 0, length);
        }
        zos.closeEntry();
        zos.close();
        arquivo = out.toByteArray();
		
		return arquivo;
	}
	
	public static byte[] recuperarArquivoDeDiretorioParaZipBytes(String caminhoDiretorio, String nomeArquivo) throws RuntimeException, IOException{
		
		InputStream is = recuperarArquivoDeDiretorio(caminhoDiretorio,nomeArquivo);
		
		byte[] arquivo = converterInputStreamParaZipBytes(nomeArquivo,is);
		
		return arquivo;
	}
	
	
	public static String gerarMD5deArquivo(byte[] arquivo){
		
		String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(arquivo);
		
		return md5;
	}
	
	public static String gerarMD5deArquivo(InputStream inputStreamArquivo) throws IOException{
		
		byte[] arquivoBytes = converterInputStreamToByteArray(inputStreamArquivo);
		
		String md5 = gerarMD5deArquivo(arquivoBytes);
		
		return md5;
	}
	
	public static String gerarSHA256deArquivo(byte[] arquivo){
		
		String sha256 = org.apache.commons.codec.digest.DigestUtils.sha256Hex(arquivo);
		
		return sha256;
	}
	
	public static String gerarSHA256deArquivo(InputStream inputStreamArquivo) throws IOException{
		
		byte[] arquivoBytes = converterInputStreamToByteArray(inputStreamArquivo);
		
		String sha256 = gerarSHA256deArquivo(arquivoBytes);
		
		return sha256;
	}

}