package character.thought;

/**
 * Roles that Topics can take in an interaction
 * 
 * @author borah
 *
 */
public enum ThetaRole {
	/** Performer of an action that does an active act to cause it */
	AGENT,
	/** Only applies to metathoughts; indicates who experienced the metathought */
	EXPERIENCER,
	/** General undergoer of an event */
	THEME,
	/** Undergoer of an action done by someone else */
	PATIENT,
	/** Used to complete an action */
	INSTRUMENT,
	/** Location of an action or something similar */
	CIRCUMSTANCE
}
