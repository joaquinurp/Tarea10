package TestTablon;

import static org.junit.Assert.*;


import org.junit.Test;

import junio2013.AnuncianteNoExisteException;
import junio2013.Anuncio;
import junio2013.IBaseDeDatosDeAnunciantes;
import junio2013.IBaseDeDatosDePagos;
import junio2013.TablonDeAnuncios;

public class TATest {
	
	private static final IBaseDeDatosDeAnunciantes IBDAnunciantes = null;
	private static final IBaseDeDatosDePagos IBDPagos = null;
	

	@Test
	public void Test1HayAnuncioEnTablon() {
		TablonDeAnuncios tablon = new TablonDeAnuncios();
		assertEquals(1,tablon.anunciosPublicados());
	}
	
	@Test
	public void Test2AnuncioLAEMPRESAComprobarAumenta() {
		
		TablonDeAnuncios tablon = new TablonDeAnuncios();
		Anuncio adEmpresa = new Anuncio("", "", "LA EMPRESA");
		int anuncios = tablon.anunciosPublicados();
		tablon.publicarAnuncio(adEmpresa, IBDAnunciantes, IBDPagos);
		assertEquals(anuncios+1, tablon.anunciosPublicados());
		
	}

}
