package org.masterserver.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "\"player\"")
public class PlayerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "uuid", length = 50)
	private String uuid;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "prefix", length = 50)
	private String prefix;

	@Column(name = "name_color", length = 20)
	private String nameColor;

	@Column(name = "name_format", length = 2)
	private String nameFormat;

	@Column(name = "prefix_color", length = 20)
	private String prefixColor;

	@Column(name = "prefix_format", length = 2)
	private String prefixFormat;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Europe/Madrid")
	@Column(name = "first_login")
	private LocalDateTime firstLogin;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Europe/Madrid")
	@Column(name = "last_login")
	private LocalDateTime lastLogin;

	@Column(name = "time_played")
	private long timePlayed;
	
	@Column(name = "online")
	private boolean online;

	@Column(name = "ip", length = 50)
	private String ip;

	@OneToMany(mappedBy = "assasin", fetch = FetchType.EAGER)
	private Set<DeathModel> assasins = new HashSet<>();

	@OneToMany(mappedBy = "murdered", fetch = FetchType.EAGER)
	private Set<DeathModel> murdereds = new HashSet<>();

	@OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
	private Set<CommandModel> commands = new HashSet<>();

	@OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
	private Set<PunishmentModel> punishments = new HashSet<>();

	@OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
	private Set<WarpModel> warps = new HashSet<>();
	
	@OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
	private Set<AchievementModel> achievements = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="rank_id")
	private RankModel rank;

	public PlayerModel() {

	}
	
	public PlayerModel(long id) {
		this.id = id;
	}

	public PlayerModel(long id, String uuid, String name, String prefix, String nameColor, String nameFormat,
			String prefixColor, String prefixFormat, LocalDateTime firstLogin, LocalDateTime lastLogin, long timePlayed,
			boolean online, String ip, Set<DeathModel> assasins, Set<DeathModel> murdereds, Set<CommandModel> commands,
			Set<PunishmentModel> punishments, Set<WarpModel> warps, Set<AchievementModel> achievements,
			RankModel rank) {
		this.id = id;
		this.uuid = uuid;
		this.name = name;
		this.prefix = prefix;
		this.nameColor = nameColor;
		this.nameFormat = nameFormat;
		this.prefixColor = prefixColor;
		this.prefixFormat = prefixFormat;
		this.firstLogin = firstLogin;
		this.lastLogin = lastLogin;
		this.timePlayed = timePlayed;
		this.online = online;
		this.ip = ip;
		this.assasins = assasins;
		this.murdereds = murdereds;
		this.commands = commands;
		this.punishments = punishments;
		this.warps = warps;
		this.achievements = achievements;
		this.rank = rank;
	}
	
	public PlayerModel(long id, String uuid, String name, String prefix, String nameColor, String nameFormat,
			String prefixColor, String prefixFormat, LocalDateTime firstLogin, LocalDateTime lastLogin, long timePlayed,
			boolean online, String ip) {
		this.id = id;
		this.uuid = uuid;
		this.name = name;
		this.prefix = prefix;
		this.nameColor = nameColor;
		this.nameFormat = nameFormat;
		this.prefixColor = prefixColor;
		this.prefixFormat = prefixFormat;
		this.firstLogin = firstLogin;
		this.lastLogin = lastLogin;
		this.timePlayed = timePlayed;
		this.online = online;
		this.ip = ip;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getNameColor() {
		return nameColor;
	}

	public void setNameColor(String nameColor) {
		this.nameColor = nameColor;
	}

	public String getNameFormat() {
		return nameFormat;
	}

	public void setNameFormat(String nameFormat) {
		this.nameFormat = nameFormat;
	}

	public String getPrefixColor() {
		return prefixColor;
	}

	public void setPrefixColor(String prefixColor) {
		this.prefixColor = prefixColor;
	}

	public String getPrefixFormat() {
		return prefixFormat;
	}

	public void setPrefixFormat(String prefixFormat) {
		this.prefixFormat = prefixFormat;
	}

	public LocalDateTime getFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(LocalDateTime firstLogin) {
		this.firstLogin = firstLogin;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public long getTimePlayed() {
		return timePlayed;
	}

	public void setTimePlayed(long timePlayed) {
		this.timePlayed = timePlayed;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Set<DeathModel> getAssasins() {
		return assasins;
	}

	public void setAssasins(Set<DeathModel> assasins) {
		this.assasins = assasins;
	}

	public Set<DeathModel> getMurdereds() {
		return murdereds;
	}

	public void setMurdereds(Set<DeathModel> murdereds) {
		this.murdereds = murdereds;
	}

	public Set<CommandModel> getCommands() {
		return commands;
	}

	public void setCommands(Set<CommandModel> commands) {
		this.commands = commands;
	}

	public Set<PunishmentModel> getPunishments() {
		return punishments;
	}

	public void setPunishments(Set<PunishmentModel> punishments) {
		this.punishments = punishments;
	}

	public Set<WarpModel> getWarps() {
		return warps;
	}

	public void setWarps(Set<WarpModel> warps) {
		this.warps = warps;
	}

	public Set<AchievementModel> getAchievements() {
		return achievements;
	}

	public void setAchievements(Set<AchievementModel> achievements) {
		this.achievements = achievements;
	}

	public RankModel getRank() {
		return rank;
	}

	public void setRank(RankModel rank) {
		this.rank = rank;
	}
}
