package simulations.objLoader;

import engine.buffers.MeshVAO;
import engine.configs.CCW;
import engine.core.Geometrics;
import engine.core.Texture;
import engine.core.Util;
import engine.core.Vertex;
import engine.math.Vec3f;
import engine.modeling.Mesh;
import engine.scenegraph.GameObject;
import engine.scenegraph.components.Material;
import engine.scenegraph.components.MeshRenderer;

public class ActionBoxModel extends GameObject{
	
	public ActionBoxModel(){
		
		getTransform().setLocalScaling(5000, 5000, 5000);
		Mesh mesh = Geometrics.Cube();
		for(Vertex vertex : mesh.getVertices()){
			vertex.setTextureCoord(vertex.getTextureCoord().mul(1));
		}
		Util.generateNormalsCCW(mesh.getVertices(), mesh.getIndices());
		Material material = new Material();
		material.setColor(new Vec3f(1,1,1));
		material.setDiffusemap(new Texture("./res/textures/materials/metal/black metal small holes/black metal small holes.jpg"));
		material.setNormalmap(new Texture("./res/textures/materials/metal/black metal small holes/black metal small holes_NRM.jpg"));
		material.setEmission(0.2f);
		material.setShininess(10);
		material.getDiffusemap().bind();
		material.getDiffusemap().mipmap();
		material.getNormalmap().bind();
		material.getNormalmap().mipmap();
		MeshVAO meshBuffer = new MeshVAO();
		meshBuffer.addData(mesh);
		MeshRenderer renderer = new MeshRenderer(meshBuffer,engine.shaders.phong.Bumpy.getInstance(), new CCW());
		addComponent("Material", material);
		addComponent("Renderer", renderer);	
	}
}