package character.thought;

/**
 * Roles that Topics can take in an interaction.
 * 
 * *Not fully equivalent to linguistic theta-roles.
 * 
 * @author borah
 *
 */
public enum ThetaRole {
	/** Performer of an action that does an active act to cause it */
	AGENT,
	/** Only applies to metathoughts; indicates who experienced the metathought */
	EXPERIENCER,
	/** Undergoer of an action or change */
	PATIENT,
	/** Topic of a conversation */
	THEME,
	/** Used to complete an action */
	INSTRUMENT,
	/** Location of an action or something similar */
	CIRCUMSTANCE
}
