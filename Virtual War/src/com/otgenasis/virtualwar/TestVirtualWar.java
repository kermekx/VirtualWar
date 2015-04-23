package com.otgenasis.virtualwar;

import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

public class TestVirtualWar {
	
	//les deplacement du char
	@Test
	public void testDeplacementCharEnDiagonalUneCase() {
		//Given 
		VirtualWar vw = new VirtualWar();
		List<String> args = new ArrayList<String>();
		//When		
		args.add(0, "move");
		args.add(1, "5");
		args.add(2, "1");
		args.add(3, "1");
		//Then
		Assert.assertFalse(vw.action(args));		 	
		
	}
	
	
	@Test
	public void TestDeplacementCharEnLigneUneCase(){
		// Le char se deplace de 1 case devant lui 
		//Given 
		VirtualWar vw = new VirtualWar();
		List<String> args = new ArrayList<String>();
		//when
		args.add(0, "move");
		args.add(1, "5");
		args.add(2, "0");
		args.add(3, "1");
		//Then
		Assert.assertTrue(vw.action(args));		
	}
	
	
	@Test
	public void TestDeplacementCharEnLigneDeuxCase(){
		//Le char se deplace de 2 case devant lui 
		//Given 
		VirtualWar vw = new VirtualWar();
		List<String> args = new ArrayList<String>();
		//when		
		args.add(0, "move");
		args.add(1, "5");
		args.add(2, "0");				
		args.add(3, "2");
		//Then
		Assert.assertTrue(vw.action(args));
		
	}
	
	@Test
	public void TestDeplacementCharEnLigneTroisCase(){
		//Le char se deplace de 3 case devant lui 
		//Given 
		VirtualWar vw = new VirtualWar();
		List<String> args = new ArrayList<String>();
		//when		
		args.add(0, "move");
		args.add(1, "5");
		args.add(2, "0");				
		args.add(3, "3");
		//Then
		Assert.assertFalse(vw.action(args));
		
	}
	
	//Test deplacement tireur 

		@Test
		public void testDeplacementTireurEnDiagonalUneCase() {
			//Given 
			VirtualWar vw = new VirtualWar();
			List<String> args = new ArrayList<String>();
			//When		
			args.add(0, "move");
			args.add(1, "1");
			args.add(2, "1");
			args.add(3, "1");
			//Then
			Assert.assertFalse(vw.action(args));		 	
			
		}
		
		@Test
		public void testDeplacementTireurEnDiagonalDeuxCase() {
			//Given 
			VirtualWar vw = new VirtualWar();
			List<String> args = new ArrayList<String>();
			//When		
			args.add(0, "move");
			args.add(1, "1");
			args.add(2, "2");
			args.add(3, "2");
			//Then
			Assert.assertFalse(vw.action(args));		 	
			
		}
		
		
		@Test
		public void TestDeplacementTireurEnLigneUneCase(){
			// Le char se deplace de 1 case devant lui 
			//Given 
			VirtualWar vw = new VirtualWar();
			List<String> args = new ArrayList<String>();
			//when
			args.add(0, "move");
			args.add(1, "1");
			args.add(2, "0");
			args.add(3, "1");
			//Then
			Assert.assertTrue(vw.action(args));		
		}
		
		
		@Test
		public void TestDeplacementTireurrEnLigneDeuxCase(){
			//Le char se deplace de 2 case devant lui 
			//Given 
			VirtualWar vw = new VirtualWar();
			List<String> args = new ArrayList<String>();
			//when		
			args.add(0, "move");
			args.add(1, "1");
			args.add(2, "0");				
			args.add(3, "2");
			//Then
			Assert.assertFalse(vw.action(args));
			
		}
		
		//Test deplacement piegeur

				@Test
				public void testDeplacementPiegeurEnDiagonalUneCase() {
					//Given 
					VirtualWar vw = new VirtualWar();
					List<String> args = new ArrayList<String>();
					//When		
					args.add(0, "move");
					args.add(1, "3");
					args.add(2, "1");
					args.add(3, "1");
					//Then
					Assert.assertTrue(vw.action(args));		 	
					
				}
				
				@Test
				public void testDeplacementPiegeurEnDiagonalDeuxCase() {
					//Given 
					VirtualWar vw = new VirtualWar();
					List<String> args = new ArrayList<String>();
					//When		
					args.add(0, "move");
					args.add(1, "3");
					args.add(2, "2");
					args.add(3, "2");
					//Then
					Assert.assertFalse(vw.action(args));		 	
					
				}
				
				
				@Test
				public void TestDeplacementPiegeurEnLigneUneCase(){
					
					//Given 
					VirtualWar vw = new VirtualWar();
					List<String> args = new ArrayList<String>();
					//when
					args.add(0, "move");
					args.add(1, "3");
					args.add(2, "0");
					args.add(3, "1");
					//Then
					Assert.assertTrue(vw.action(args));		
				}
				
				
				@Test
				public void TestDeplacementPiegeurEnLigneDeuxCase(){
					 
					//Given 
					VirtualWar vw = new VirtualWar();
					List<String> args = new ArrayList<String>();
					//when		
					args.add(0, "move");
					args.add(1, "3");
					args.add(2, "0");				
					args.add(3, "2");
					//Then
					Assert.assertFalse(vw.action(args));
					
				}
	
		//poser mine  
				
				//Test poser mine avec piegeur

				@Test
				public void testPoserMinePiegeurEnDiagonalUneCase() {
					//Given 
					VirtualWar vw = new VirtualWar();
					List<String> args = new ArrayList<String>();
					args.add(0, "move");
					args.add(1, "3");
					args.add(2, "1");
					args.add(3, "1");
					vw.action(args);
					//When		
					args.add(0, "mine");
					args.add(1, "5");
					args.add(2, "2");
					args.add(3, "2");
					//Then
					Assert.assertTrue(vw.action(args));		 	
					
				}
				
				@Test
				public void testPoserMinePiegeurEnDiagonalDeuxCase() {
					//Given 
					VirtualWar vw = new VirtualWar();
					List<String> args = new ArrayList<String>();
					args.add(0, "move");
					args.add(1, "3");
					args.add(2, "1");
					args.add(3, "1");
					vw.action(args);
					//When		
					args.add(0, "mine");
					args.add(1, "5");
					args.add(2, "3");
					args.add(3, "3");
					//Then
					Assert.assertFalse(vw.action(args));		 	
					
				}
				
				
				@Test
				public void testPoserMinePiegeurEnLigneUneCase(){
					
					//Given 
					VirtualWar vw = new VirtualWar();
					List<String> args = new ArrayList<String>();
					args.add(0, "move");
					args.add(1, "3");
					args.add(2, "1");
					args.add(3, "1");
					vw.action(args);
					//when
					args.add(0, "mine");
					args.add(1, "5");
					args.add(2, "1");
					args.add(3, "2");
					//Then
					Assert.assertTrue(vw.action(args));		
				}
				
				
				@Test
				public void testPoserMinePiegeurEnLigneDeuxCase(){
					 
					//Given 
					VirtualWar vw = new VirtualWar();
					List<String> args = new ArrayList<String>();
					args.add(0, "move");
					args.add(1, "3");
					args.add(2, "1");
					args.add(3, "1");
					vw.action(args);
					//when		
					args.add(0, "mine");
					args.add(1, "5");
					args.add(2, "1");
					args.add(3, "3");
					//Then
					Assert.assertFalse(vw.action(args));
					
				}
				
				
			
				//Test poser mine avec Tireur

				@Test
				public void testPoserMineTireurEnDiagonalUneCase() {
					//Given 
					VirtualWar vw = new VirtualWar();
					List<String> args = new ArrayList<String>();
					args.add(0, "move");
					args.add(1, "1");
					args.add(2, "0");
					args.add(3, "1");
					vw.action(args);
					args.add(0, "move");
					args.add(1, "5");
					args.add(2, "1");
					args.add(3, "1");
					vw.action(args);
					//When		
					args.add(0, "mine");
					args.add(1, "5");
					args.add(2, "2");
					args.add(3, "2");
					//Then
					Assert.assertFalse(vw.action(args));		 	
					
				}
				
				@Test
				public void testPoserMineTireurEnDiagonalDeuxCase() {
					//Given 
					VirtualWar vw = new VirtualWar();
					List<String> args = new ArrayList<String>();
					args.add(0, "move");
					args.add(1, "1");
					args.add(2, "0");
					args.add(3, "1");
					vw.action(args);
					args.add(0, "move");
					args.add(1, "5");
					args.add(2, "1");
					args.add(3, "1");
					vw.action(args);
					//When		
					args.add(0, "mine");
					args.add(1, "5");
					args.add(2, "3");
					args.add(3, "3");
					//Then
					Assert.assertFalse(vw.action(args));		 	
					
				}
				
				
				@Test
				public void testPoserMineTireurEnLigneUneCase(){
					
					//Given 
					VirtualWar vw = new VirtualWar();
					List<String> args = new ArrayList<String>();
					args.add(0, "move");
					args.add(1, "1");
					args.add(2, "0");
					args.add(3, "1");
					vw.action(args);
					args.add(0, "move");
					args.add(1, "5");
					args.add(2, "1");
					args.add(3, "1");
					vw.action(args);
					//when
					args.add(0, "mine");
					args.add(1, "5");
					args.add(2, "1");
					args.add(3, "2");
					//Then
					Assert.assertFalse(vw.action(args));		
				}
				
				
				@Test
				public void testPoserMineTireurEnLigneDeuxCase(){
					 
					//Given 
					VirtualWar vw = new VirtualWar();
					List<String> args = new ArrayList<String>();
					args.add(0, "move");
					args.add(1, "1");
					args.add(2, "0");
					args.add(3, "1");
					vw.action(args);
					args.add(0, "move");
					args.add(1, "5");
					args.add(2, "1");
					args.add(3, "1");
					vw.action(args);
					//when		
					args.add(0, "mine");
					args.add(1, "5");
					args.add(2, "1");
					args.add(3, "3");
					//Then
					Assert.assertFalse(vw.action(args));
					
				}
				
	
				
		
	}
	

