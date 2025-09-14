package character.rules;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import character.thought.ThetaRole;
import character.thought.base.IThought;
import character.topic.ITopic;

/**
 * A Rule that indicates the outcome of something or forbids/allows an action
 * 
 * @author borah
 *
 */
public interface IRule {
	/**
	 * The {@link IThought} that acts as the Cause for this {@link IRule}
	 * 
	 * @return
	 */
	public IThought cause();

	/**
	 * An optional set of extra thoughts that act as circumstances for this rule to
	 * occur in
	 * 
	 * @return
	 */
	public Collection<IThought> circumstances();

	/**
	 * The result of this Rule's cause occurring
	 * 
	 * @return
	 */
	public IConsequence effect();

	/**
	 * The result of this Rule's cause NOT occurring
	 * 
	 * @return
	 */
	public IConsequence violationEffect();

	/**
	 * Return true if this rule matches the thoughts in the mind
	 * 
	 * @param thought
	 * @return
	 */
	public default boolean matchesThoughts(IThought thought) {
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
		if (!rule.isTemplateForRule() || thought.isTemplateForRule()) {
			throw new IllegalArgumentException();
		}
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
