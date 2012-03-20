package net.windwaker.textureme.configuration;

import java.io.File;
import java.io.IOException;

import net.windwaker.textureme.Logger;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class Configuration extends YamlConfiguration {
	
	private File file;
	private final Logger logger = Logger.getInstance();
	
	/**
	 * Constructs a Configuration
	 * @param file to configuration file desired.
	 */
	public Configuration(File file) {
		this.file = file;
	}
	
	/**
	 * Returns the associated configuration file.
	 * @return the configuration file.
	 */
	public File getFile() {
		return file;
	}
	
	/**
	 * Sets where the configuration file is located.
	 * @param file to set.
	 */
	public void setFile(File file) {
		this.file = file;
	}
	
	/**
	 * Loads the configuration file to memory. The file is created if missing.
	 */
	public void load() {
		try {
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
				this.load(file);
				logger.config("Created and loaded config file at: " + file.getAbsolutePath());
			} else {
				this.load(file);
				logger.config("Loaded config file at: " + file.getAbsolutePath());
			}
		} catch (IOException e) {
			logger.severe("Config file at " + file.getAbsolutePath() + " failed to load: " + e.getMessage());
		} catch (InvalidConfigurationException ce) {
			logger.severe("Config file at " + file.getAbsolutePath() + " failed to load: " + ce.getMessage());
		}
	}
	
	/**
	 * Saves the configuration in memory to disk.
	 */
	public void save() {
		try {
			this.save(file);
			logger.config("Saved config file at: " + file.getAbsolutePath());
		} catch (IOException e) {
			logger.severe("Config file at " + file.getAbsolutePath() + " failed to save: " + e.getMessage());
		}
	}
}