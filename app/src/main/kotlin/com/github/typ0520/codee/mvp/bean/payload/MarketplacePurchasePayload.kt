package com.github.typ0520.codee.mvp.bean.payload

import com.github.typ0520.codee.mvp.bean.User

/**
 * Created by tong on 2017/12/26.
 */

/**
 * Triggered when a user purchases, cancels, or changes their GitHub Marketplace plan.
 *
 * https://developer.github.com/v3/activity/events/types/#marketplacepurchaseevent
 */
data class MarketplacePurchasePayload(
		val action: String, //changed
		val effective_date: String, //2017-04-06T02:01:16Z
		val marketplace_purchase: MarketplacePurchase,
		val previous_marketplace_purchase: PreviousMarketplacePurchase,
		val sender: User
): Payload() {
    companion object {
        val TYPE_NAME = "MarketplacePurchaseEvent"
    }
}

data class MarketplacePurchase(
		val account: User,
		val billing_cycle: String, //monthly
		val next_billing_date: String, //2017-05-01T00:00:00Z
		val unit_count: Int, //1
		val on_free_trial: Boolean, //true
		val free_trial_ends_on: String, //2017-11-11T00:00:00Z
		val plan: Plan
)

data class Plan(
		val id: Int, //9
		val name: String, //Super Pro
		val description: String, //A really, super professional-grade CI solution
		val monthly_price_in_cents: Int, //9999
		val yearly_price_in_cents: Int, //11998
		val price_model: String, //flat-rate
		val has_free_trial: Boolean, //true
		val unit_name: Any, //null
		val bullets: List<String>
)

data class PreviousMarketplacePurchase(
		val account: User,
		val billing_cycle: String, //monthly
		val next_billing_date: String, //2017-05-01T00:00:00Z
		val unit_count: Int, //1
		val on_free_trial: Boolean, //false
		val free_trial_ends_on: Any, //null
		val plan: Plan
)

/*
{
  "action": "changed",
  "effective_date": "2017-04-06T02:01:16Z",
  "marketplace_purchase": {
    "account": {
      "type": "Organization",
      "id": 4,
      "login": "GitHub",
      "organization_billing_email": "billing@github.com"
    },
    "billing_cycle": "monthly",
    "next_billing_date": "2017-05-01T00:00:00Z",
    "unit_count": 1,
    "on_free_trial": true,
    "free_trial_ends_on": "2017-11-11T00:00:00Z",
    "plan": {
      "id": 9,
      "name": "Super Pro",
      "description": "A really, super professional-grade CI solution",
      "monthly_price_in_cents": 9999,
      "yearly_price_in_cents": 11998,
      "price_model": "flat-rate",
      "has_free_trial": true,
      "unit_name": null,
      "bullets": [
        "This is the first bullet of the plan",
        "This is the second bullet of the plan"
      ]
    }
  },
  "previous_marketplace_purchase": {
    "account": {
      "type": "Organization",
      "id": 4,
      "login": "GitHub",
      "organization_billing_email": "billing@github.com"
    },
    "billing_cycle": "monthly",
    "next_billing_date": "2017-05-01T00:00:00Z",
    "unit_count": 1,
    "on_free_trial": false,
    "free_trial_ends_on": null,
    "plan": {
      "id": 9,
      "name": "Super Pro",
      "description": "A really, super professional-grade CI solution",
      "monthly_price_in_cents": 9999,
      "yearly_price_in_cents": 11998,
      "price_model": "flat-rate",
      "has_free_trial": true,
      "unit_name": null,
      "bullets": [
        "This is the first bullet of the plan",
        "This is the second bullet of the plan"
      ]
    }
  },
  "sender": {
    "id": 1,
    "login": "octocat",
    "email": "octocat@github.com"
  }
}
 */
