package clientname.gui.hud;

public interface IRenderConfig {
  void save(ScreenPosition paramScreenPosition);
  
  ScreenPosition load();
}
