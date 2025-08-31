package character.rules;

import java.util.HashSet;
import java.util.Set;

import character.targeting.ITopic;
import character.thought.IThought;
import character.thought.IThoughtArgument;
import character.thought.ThetaRole;

/**
 * A Rule that indicates the outcome of something or forbids/allows an action
 * 
 * @author borah
 *
 */
public interface IRule extends IThoughtArgument {
	/**
	 * The {@link IThought} that acts as the Cause for this {@link IRule}
	 * 
	 * @return
	 */
	public IThought cause();

	/**
	 * The result of this Rule's cause occurring
	 * 
	 * @return
	 */
	public IConsequence effect();

	/**
	 * Return true if this rule's cause matches the given thought
	 * 
	 * @param thought
	 * @return
	 */
	public default boolean matchesThought(IThought thought) {
		return match(this.cause(), thought);
	}

	/**
	 * Checks if the first Thought, acting as a "rule" with templates, matches tthe
	 * second thought, which should have Unique Topics
	 * 
	 * @param toMatch
	 * @return
	 */
	public static boolean match(IThought rule, IThought thought) {
		for (ThetaRole theta : ThetaRole.values()) {
			Set<ITopic> checkedTopics = new HashSet<>(thought.allTopics().size()); // topics already checked
			rule_role_loop: for (ITopic ruleRole : rule.topicsForThetaRole(theta)) {
				// each rule topic must be filled by one (unique) topic
				for (ITopic thoughtTopic : thought.topicsForThetaRole(theta)) {
					if (checkedTopics.contains(thoughtTopic))
						continue;
					if (thoughtTopic.asUnique().filter(ruleRole::matches).isPresent()) { // if this topic fits the
																							// rule role
						checkedTopics.add(thoughtTopic); // can't use it twice
						continue rule_role_loop; // check next rule
					}
				}
				return false;
			}
		}
		return true;
	}

}
