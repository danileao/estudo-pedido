package br.com.acumen.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.inject.Inject;

import br.com.acumen.DAO.DAOException;
import br.com.acumen.DAO.ReciboDAO;
import br.com.acumen.model.CategoriaEnum;
import br.com.acumen.model.CentroCustoEnum;
import br.com.acumen.model.Recibo;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.download.ByteArrayDownload;
import br.com.caelum.vraptor.observer.download.Download;
import br.com.caelum.vraptor.observer.upload.UploadSizeLimit;
import br.com.caelum.vraptor.observer.upload.UploadedFile;

@Controller
public class ReciboController {

	@Inject
	private Result result;
	
	@Inject
	private ReciboDAO reciboDAO;
	
	@Path("/cadastrarRecibo")
	public void cadastrarRecibo(){
		result.include("categorias", CategoriaEnum.values());
		result.include("centros", CentroCustoEnum.values());
	}
	
	@Path("/salvarRecibo")
	@Post
	@UploadSizeLimit(sizeLimit=40 * 1024 * 1024, fileSizeLimit=10 * 1024 * 1024)
	public void salvar(Recibo recibo, UploadedFile imgRecibo) throws DAOException{
		try {
			recibo.setImagem(getBytes(imgRecibo.getFile()));
			recibo.setDataEnvio(new Date());
			recibo.setUsuario("José Carlos");
			
			reciboDAO.insert(recibo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.redirectTo(this).cadastrarRecibo();
	}
	

	@Path("/buscarRecibo")
	public void buscar() throws DAOException{
		Recibo find = reciboDAO.find(1L);
		System.out.println(find.getUsuario());
	}
	
	@Path("/mostrar")
	public void mostrar(){
	}
	
	@Get("/{id}/buscarIMG")
	public Download buscarIMG(Long id) throws DAOException{
		Recibo find = reciboDAO.find(id);
		return new ByteArrayDownload(find.getImagem(), null,null);
	}
	
	
	public static byte[] getBytes(InputStream is) throws IOException {

	    int len;
	    int size = 1024;
	    byte[] buf;

	    if (is instanceof ByteArrayInputStream) {
	      size = is.available();
	      buf = new byte[size];
	      len = is.read(buf, 0, size);
	    } else {
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      buf = new byte[size];
	      while ((len = is.read(buf, 0, size)) != -1)
	        bos.write(buf, 0, len);
	      buf = bos.toByteArray();
	    }
	    return buf;
	  }
}
