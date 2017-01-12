package driver;

import java.util.*;

import lLHandler.Switch;
import nLHandler.Router;

public class AS {
	ArrayList<Router> Routers;
	ArrayList<Node> Nodes;
    HashMap<Router,Node> RNconxns;
    HashMap<Switch,Node> SNconxns;
    HashMap<Node,Node> NNConxns;
    String RTproto;
    
}
