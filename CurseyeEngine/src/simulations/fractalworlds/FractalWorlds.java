package simulations.fractalworlds;

import modules.gui.GUI;
import modules.gui.GUIs.EngineGUI;
import modules.lighting.DirectionalLight;
import engine.main.CoreEngine;
import engine.main.RenderingEngine;
import engine.math.Vec3f;
import simulations.templates.Simulation;
import simulations.templates.TerrainSimulation;

public class FractalWorlds extends TerrainSimulation{
	
	public static void main(String[] args) {
		Simulation simulation = new FractalWorlds();
		GUI gui = new EngineGUI();
		CoreEngine coreEngine = new CoreEngine(800, 600, "TerrainLoader", simulation, gui);
		coreEngine.createWindow();
		coreEngine.start();
	}

	public void init()
	{	
		super.init();
		setTerrain(new Terrain());
//		setWater(new Ocean());
		RenderingEngine.setDirectionalLight(new DirectionalLight(new Vec3f(-4,-2,-1).normalize(), new Vec3f(0.04f,0.04f,0.04f), new Vec3f(1.0f, 0.95f, 0.87f), 1.5f));
	}
}