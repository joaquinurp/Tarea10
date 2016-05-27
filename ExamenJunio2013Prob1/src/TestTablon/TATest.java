package TestTablon;

import static org.junit.Assert.*;


import org.junit.Test;

import static org.mockito.Mockito.*;

import junio2013.AnuncianteNoExisteException;
import junio2013.Anuncio;
import junio2013.IBaseDeDatosDeAnunciantes;
import junio2013.IBaseDeDatosDePagos;
import junio2013.TablonDeAnuncios;

public class TATest {
	
	private static final IBaseDeDatosDeAnunciantes IBDAnunciantes = null;
	private static final IBaseDeDatosDePagos IBDPagos = null;
	
	TablonDeAnuncios tablon = new TablonDeAnuncios();
	
	
	@Test
	public void Test1HayAnuncioEnTablon() {
		assertEquals(1,tablon.anunciosPublicados());
	}
	
	@Test
	public void Test2AnuncioLAEMPRESAComprobarAumenta() {
		
		Anuncio adEmpresa = new Anuncio("", "", "LA EMPRESA");
		int anuncios = tablon.anunciosPublicados();
		tablon.publicarAnuncio(adEmpresa, IBDAnunciantes, IBDPagos);
		assertEquals(anuncios+1, tablon.anunciosPublicados());
		
	}
	
	@Test
	public void Test3AnuncioSinSaldoNoIncrementa() {
		IBaseDeDatosDeAnunciantes ads = mock(IBaseDeDatosDeAnunciantes.class);
		IBaseDeDatosDePagos pa = mock(IBaseDeDatosDePagos.class);
		when(ads.buscarAnunciante("Alguien")).thenReturn(true);
		when(pa.anuncianteTieneSaldo("Alguien")).thenReturn(false);
		Anuncio NOEMPRESA = new Anuncio("x", "x", "Alguien");
		tablon.publicarAnuncio(NOEMPRESA, ads, pa);
		assertEquals(tablon.anunciosPublicados(), 1);
		
	}
	
	
	
	@Test
	public void Test4AnuncioNOEMPRESAVerificarMetodo() {
		
		IBaseDeDatosDeAnunciantes ads=mock(IBaseDeDatosDeAnunciantes.class);
		IBaseDeDatosDePagos pa=mock(IBaseDeDatosDePagos.class);
		when(ads.buscarAnunciante("Alguien")).thenReturn(true);
		when(pa.anuncianteTieneSaldo("Alguien")).thenReturn(true);
		Anuncio noEmpresa=new Anuncio("x","x","Alguien");
		tablon.publicarAnuncio(noEmpresa, ads, pa);
		//Metodo a verificar
		pa.anuncioPublicado("Pepe");
		assertEquals(tablon.anunciosPublicados(),2);	
	
	}
	
	@Test
	public void Test5CrearAnuncioBuscarAnuncio() {
		
		Anuncio comp1 = new Anuncio("x","x","LA EMPRESA");
		tablon.publicarAnuncio(comp1, IBDAnunciantes, IBDPagos);
		Anuncio comp2 = new Anuncio("y","y","LA EMPRESA");
		tablon.publicarAnuncio(comp2, IBDAnunciantes, IBDPagos);
		int Atotales = tablon.anunciosPublicados();
		tablon.buscarAnuncioPorTitulo("Prueba2");
		assertEquals(tablon.anunciosPublicados(),Atotales);
		
	}

}
