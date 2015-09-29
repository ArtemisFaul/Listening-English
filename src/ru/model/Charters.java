package ru.model;

public class Charters {

	public Charters(String id,String name, String modelName, String modelDescription, String intro, String exercise, String key,
			String varFile, String type, String exAttachFile, String keyAttachFile, String audioscriptFile) {
		super();
		this.id = id;
		this.name = name;
		this.modelName = modelName;
		this.modelDescription = modelDescription;
		this.intro = intro;
		this.exercise = exercise;
		this.key = key;
		this.varFile = varFile;
		this.type = type;
		this.exAttachFile = exAttachFile;
		this.keyAttachFile = keyAttachFile;
		this.audioscriptFile = audioscriptFile;
	}
	private String id;
	private String name;
	private String modelName;
	private String modelDescription;
	private String intro;
	private String exercise;
	private String key;
	private String varFile;
	private String type;
	private String exAttachFile;
	private String keyAttachFile;
	private String audioscriptFile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelDescription() {
		return modelDescription;
	}
	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getExercise() {
		return exercise;
	}
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getVarFile() {
		return varFile;
	}
	public void setVarFile(String varFile) {
		this.varFile = varFile;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExAttachFile() {
		return exAttachFile;
	}
	public void setExAttachFile(String exAttachFile) {
		this.exAttachFile = exAttachFile;
	}
	public String getKeyAttachFile() {
		return keyAttachFile;
	}
	public void setKeyAttachFile(String keyAttachFile) {
		this.keyAttachFile = keyAttachFile;
	}
	public String getAudioscriptFile() {
		return audioscriptFile;
	}
	public void setAudioscriptFile(String audioscriptFile) {
		this.audioscriptFile = audioscriptFile;
	}
	@Override
	public String toString() {
		return "Charters [id=" + id + ",name=" + name + ", modelName=" + modelName + ", modelDescription=" + modelDescription
				+ ", intro=" + intro + ", exercise=" + exercise + ", key=" + key + ", varFile=" + varFile + ", type="
				+ type + ", exAttachFile=" + exAttachFile + ", keyAttachFile=" + keyAttachFile + ", audioscriptFile="
				+ audioscriptFile + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
