package vb.$randomcrafts;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	public static Object GLOBAL_27b33d09036562b0dc63228eb1686876;

	@Override
	public void onEnable() {
		instance = this;
		getDataFolder().mkdir();
		getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("randomize-crafts")) {
			try {
				org.bukkit.Bukkit.broadcastMessage("Crafts are now randomized!");
				PluginMain.GLOBAL_27b33d09036562b0dc63228eb1686876 = ((java.lang.Object) (Object) true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return true;
	}

	public static void procedure(String procedure, List procedureArgs) throws Exception {
	}

	public static Object function(String function, List functionArgs) throws Exception {
		return null;
	}

	public static List createList(Object obj) {
		List list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else if (obj instanceof Iterator) {
			((Iterator<?>) obj).forEachRemaining(list::add);
		} else {
			list.add(obj);
		}
		return list;
	}

	public static void createResourceFile(String path) {
		Path file = getInstance().getDataFolder().toPath().resolve(path);
		if (Files.notExists(file)) {
			try (InputStream inputStream = PluginMain.class.getResourceAsStream("/" + path)) {
				Files.createDirectories(file.getParent());
				Files.copy(inputStream, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PluginMain getInstance() {
		return instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPrepareItemCraftEvent1(org.bukkit.event.inventory.PrepareItemCraftEvent event) throws Exception {
		if (PluginMain.checkEquals(GLOBAL_27b33d09036562b0dc63228eb1686876, ((java.lang.Object) (Object) true))) {
			event.getInventory()
					.setResult(
							new org.bukkit.inventory.ItemStack(
									((org.bukkit.Material) (Object) PluginMain.createList(org.bukkit.Material.values())
											.get(java.util.concurrent.ThreadLocalRandom.current().nextInt(
													PluginMain.createList(org.bukkit.Material.values()).size()))),
									java.util.concurrent.ThreadLocalRandom.current().nextInt(((int) 1d),
											((int) 64d) + 1)));
		}
	}

	public static boolean checkEquals(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return false;
		}
		return o1 instanceof Number && o2 instanceof Number
				? ((Number) o1).doubleValue() == ((Number) o2).doubleValue()
				: o1.equals(o2);
	}
}
